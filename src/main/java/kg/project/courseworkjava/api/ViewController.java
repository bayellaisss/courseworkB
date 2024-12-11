package kg.project.courseworkjava.api;

import kg.project.courseworkjava.model.security.SignInRequest;
import kg.project.courseworkjava.model.security.SignUpRequest;
import kg.project.courseworkjava.service.ApplicationService;
import kg.project.courseworkjava.service.impl.UserDetailsImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String index(Model model, Authentication authentication) {
        model.addAttribute("isAuthenticated", authentication != null && authentication.isAuthenticated());
        return "index";
    }

    @GetMapping("/faculties")
    public String faculties(Model model, Authentication authentication){
        model.addAttribute("isAuthenticated", authentication != null && authentication.isAuthenticated());
        return "faculties";
    }

    @GetMapping("/admission")
    public String admission(Model model, Authentication authentication){
        model.addAttribute("isAuthenticated", authentication != null && authentication.isAuthenticated());
        return "admission";
    }

    @GetMapping("/contact")
    public String contact(Model model, Authentication authentication){
        model.addAttribute("isAuthenticated", authentication != null && authentication.isAuthenticated());
        return "contact";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("signInRequest", new SignInRequest());
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("signUpRequest", new SignUpRequest());
        return "register";
    }
//    @GetMapping("/")
//    public String index() {
//        return "index"; // Если у вас есть index.html
//    }

    @GetMapping("/my_applications")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String myApplications(Model model, Authentication authentication, ApplicationService applicationService) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("applications", applicationService.getByStudent(userDetails.getId()));
        model.addAttribute("isAuthenticated", true);
        return "my_applications";
    }
}
