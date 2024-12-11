package kg.project.courseworkjava.service.impl;

import kg.project.courseworkjava.entity.Program;
import kg.project.courseworkjava.exception.EntityNotFoundException;
import kg.project.courseworkjava.repos.ProgramRepos;
import kg.project.courseworkjava.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramServiceImpl implements ProgramService {
    @Autowired
    ProgramRepos programRepository;

    @Override
    public List<Program> getProgramsByUniversity(Long universityId) {
        return programRepository.findByUniversityId(universityId);
    }

    @Override
    public Program getById(Long id) {
        return programRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Program not found"));
    }
}