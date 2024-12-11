package kg.project.courseworkjava.service;


import kg.project.courseworkjava.entity.University;
import kg.project.courseworkjava.model.UniversityRequest;
import kg.project.courseworkjava.model.UniversityResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UniversityService{
//    public UniversityResponse create(UniversityRequest universityRequest);
//    public UniversityResponse findById(Long id);
//    public UniversityResponse update(UniversityRequest universityRequest, Long universityId);
//    public List<UniversityResponse> findAll();
//    public void deleteById(Long id);
//    public Page<UniversityResponse> getAllByFilterUniversity(
//            String name,
//            String city,
//            int page,
//            int size);

    public List<University> getAll();

    public University getById(Long id);
}
