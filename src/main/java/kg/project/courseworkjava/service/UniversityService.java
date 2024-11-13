package kg.project.courseworkjava.service;


import kg.project.courseworkjava.model.UniversityRequest;
import kg.project.courseworkjava.model.UniversityResponse;

import java.util.List;

public interface UniversityService{
    public UniversityResponse create(UniversityRequest universityRequest);
    public UniversityResponse findById(Long id);
    public UniversityResponse update(UniversityRequest universityRequest, Long universityId);
    public List<UniversityResponse> findAll();
    public void deleteById(Long id);
}
