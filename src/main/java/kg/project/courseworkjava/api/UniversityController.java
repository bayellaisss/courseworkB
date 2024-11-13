package kg.project.courseworkjava.api;

import kg.project.courseworkjava.model.UniversityRequest;
import kg.project.courseworkjava.model.UniversityResponse;
import kg.project.courseworkjava.service.UniversityService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(makeFinal = true, level = PRIVATE)
@RestController
@RequestMapping("/api/v1/universities")
@RequiredArgsConstructor
@Validated
public class UniversityController {

    UniversityService universityService;

    @PostMapping("/save")
    public ResponseEntity<UniversityResponse> saveUniversity(@Valid @RequestBody UniversityRequest universityRequest) {
        UniversityResponse savedUniversity = universityService.create(universityRequest);
        return new ResponseEntity<>(savedUniversity, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<UniversityResponse> findAllUniversities() {
        return universityService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniversityResponse> getUniversityById(@PathVariable Long id) {
        UniversityResponse universityResponse = universityService.findById(id);
        return new ResponseEntity<>(universityResponse, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UniversityResponse> updateUniversity(@Valid @RequestBody UniversityRequest universityRequest, @PathVariable Long id) {
        UniversityResponse updatedUniversity = universityService.update(universityRequest, id);
        return new ResponseEntity<>(updatedUniversity, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUniversity(@PathVariable Long id) {
        universityService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
