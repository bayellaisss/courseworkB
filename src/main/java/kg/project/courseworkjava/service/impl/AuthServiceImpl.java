package kg.project.courseworkjava.service.impl;

import kg.project.courseworkjava.config.util.JWTUtils;
import kg.project.courseworkjava.entity.Role;
import kg.project.courseworkjava.entity.User;
import kg.project.courseworkjava.exception.AlreadyExistsException;
import kg.project.courseworkjava.model.security.JWTResponse;
import kg.project.courseworkjava.model.security.MessageResponse;
import kg.project.courseworkjava.model.security.SignInRequest;
import kg.project.courseworkjava.model.security.SignUpRequest;
import kg.project.courseworkjava.repos.RoleRepos;
import kg.project.courseworkjava.repos.UserRepos;
import kg.project.courseworkjava.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepos userRepository;

    @Autowired
    RoleRepos roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JWTUtils jwtUtils;

    @Override
    public JWTResponse signIn(SignInRequest signInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return new JWTResponse(jwt, userDetails.getId(), userDetails.getUsername());
    }

    @Override
    public MessageResponse signUp(SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            throw new AlreadyExistsException("Error: Username already exists");
        }

        User user = User.builder()
                .username(signUpRequest.getUsername())
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .firstName(signUpRequest.getFirstName())
                .lastName(signUpRequest.getLastName())
                .build();

        userRepository.save(user);
        return new MessageResponse("User CREATED");
    }
}