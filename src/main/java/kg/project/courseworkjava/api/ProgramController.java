package kg.project.courseworkjava.api;

import kg.project.courseworkjava.entity.Program;
import kg.project.courseworkjava.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/programs")
public class ProgramController {

    @Autowired
    private ProgramService programService;

    @GetMapping("/{id}")
    public String programDetail(@PathVariable Long id, Model model, Authentication authentication) {
        Program p = programService.getById(id);
        model.addAttribute("program", p);
        model.addAttribute("isAuthenticated", authentication != null && authentication.isAuthenticated());
        return "program_detail";
    }
}