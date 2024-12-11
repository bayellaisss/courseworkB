package kg.project.courseworkjava.api;

import kg.project.courseworkjava.entity.Application;
import kg.project.courseworkjava.entity.Program;
import kg.project.courseworkjava.service.ApplicationService;
import kg.project.courseworkjava.service.impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String showForm(@RequestParam Long programId, Model model, Authentication authentication) {
        Program program = applicationService.getProgram(programId);
        model.addAttribute("program", program);
        model.addAttribute("isAuthenticated", true);
        return "application_form";
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String create(@RequestParam Long programId, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        applicationService.createApplication(userDetails.getId(), programId);
        return "redirect:/my_applications";
    }
}