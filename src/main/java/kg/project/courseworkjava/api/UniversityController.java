package kg.project.courseworkjava.api;

import kg.project.courseworkjava.entity.University;
import kg.project.courseworkjava.model.UniversityRequest;
import kg.project.courseworkjava.model.UniversityResponse;
import kg.project.courseworkjava.service.ProgramService;
import kg.project.courseworkjava.service.UniversityService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

//@FieldDefaults(makeFinal = true, level = PRIVATE)
//@RestController
//@RequestMapping("/api/v1/universities")
//@RequiredArgsConstructor
//@Validated
//public class UniversityController {
//
//    UniversityService universityService;
//
//    @PostMapping("/save")
//    public ResponseEntity<UniversityResponse> saveUniversity(@Valid @RequestBody UniversityRequest universityRequest) {
//        UniversityResponse savedUniversity = universityService.create(universityRequest);
//        return new ResponseEntity<>(savedUniversity, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/list")
//    public List<UniversityResponse> findAllUniversities() {
//        return universityService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<UniversityResponse> getUniversityById(@PathVariable Long id) {
//        UniversityResponse universityResponse = universityService.findById(id);
//        return new ResponseEntity<>(universityResponse, HttpStatus.OK);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<UniversityResponse> updateUniversity(@Valid @RequestBody UniversityRequest universityRequest, @PathVariable Long id) {
//        UniversityResponse updatedUniversity = universityService.update(universityRequest, id);
//        return new ResponseEntity<>(updatedUniversity, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteUniversity(@PathVariable Long id) {
//        universityService.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }
//    @GetMapping("/filter")
//    public Page<UniversityResponse> getUniversities(
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String city,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size) {
//
//        return universityService.getAllByFilterUniversity(name, city, page, size);
//    }
//}


@Controller
@RequestMapping("/universities")
public class UniversityController {

    private final UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService){
        this.universityService = universityService;
    }

    @GetMapping
    public String getAll(Model model, Authentication authentication){
        model.addAttribute("universities", universityService.getAll());
        model.addAttribute("isAuthenticated", authentication!=null && authentication.isAuthenticated());
        return "universities";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model, Authentication authentication, ProgramService programService){
        University uni = universityService.getById(id);
        model.addAttribute("university", uni);
        model.addAttribute("programs", programService.getProgramsByUniversity(id));
        model.addAttribute("isAuthenticated", authentication!=null && authentication.isAuthenticated());
        return "university_detail";
    }
}