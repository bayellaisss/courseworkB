package kg.project.courseworkjava.api;

import kg.project.courseworkjava.model.security.JWTResponse;
import kg.project.courseworkjava.model.security.MessageResponse;
import kg.project.courseworkjava.model.security.SignInRequest;
import kg.project.courseworkjava.model.security.SignUpRequest;
import kg.project.courseworkjava.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web")
public class AuthWebController {

    private final AuthService authService;

    public AuthWebController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {
        try {
            // Создаём SignInRequest из параметров формы
            SignInRequest signInRequest = new SignInRequest();
            signInRequest.setUsername(username);
            signInRequest.setPassword(password);

            JWTResponse jwtResponse = authService.signIn(signInRequest);

            // JWTResponse содержит token. Обычно JWT хранят в куках или в session.
            // Для примера положим в session attribute:
            model.addAttribute("token", jwtResponse.getToken());

            // Перенаправим на главную страницу или профиль пользователя:
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("error", "Неверный логин или пароль");
            return "login";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@RequestParam String username,
                                  @RequestParam String password,
                                  @RequestParam String email,
                                  @RequestParam(required = false) String firstName,
                                  @RequestParam(required = false) String lastName,
                                  @RequestParam Long roleId,
                                  Model model) {
        try {
            SignUpRequest signUpRequest = new SignUpRequest();
            signUpRequest.setUsername(username);
            signUpRequest.setPassword(password);
            signUpRequest.setEmail(email);
            signUpRequest.setFirstName(firstName);
            signUpRequest.setLastName(lastName);
            signUpRequest.setRoleId(roleId);

            MessageResponse response = authService.signUp(signUpRequest);

            // Если успешно, перенаправим на страницу логина
            return "redirect:/web/login";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
}
