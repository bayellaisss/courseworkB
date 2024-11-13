package kg.project.courseworkjava.service;


import kg.project.courseworkjava.model.security.JWTResponse;
import kg.project.courseworkjava.model.security.MessageResponse;
import kg.project.courseworkjava.model.security.SignInRequest;
import kg.project.courseworkjava.model.security.SignUpRequest;

public interface AuthService {
    JWTResponse signIn(SignInRequest signInRequest);
    MessageResponse signUp(SignUpRequest signUpRequest);

}
