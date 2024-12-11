package kg.project.courseworkjava.service.impl;

import kg.project.courseworkjava.entity.Application;
import kg.project.courseworkjava.entity.Program;
import kg.project.courseworkjava.entity.User;
import kg.project.courseworkjava.exception.EntityNotFoundException;
import kg.project.courseworkjava.repos.ApplicationRepos;
import kg.project.courseworkjava.repos.ProgramRepos;
import kg.project.courseworkjava.repos.UserRepos;
import kg.project.courseworkjava.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    ApplicationRepos applicationRepository;

    @Autowired
    UserRepos userRepos;

    @Autowired
    ProgramRepos programRepository;


    @Override
    public Program getProgram(Long programId) {
        return programRepository.findById(programId).orElseThrow(() -> new EntityNotFoundException("Program not found"));
    }
    @Override
    public Application createApplication(Long userId, Long programId) {
        User user = userRepos.findById(userId).orElseThrow(()-> new EntityNotFoundException("User not found"));
        Program program = programRepository.findById(programId).orElseThrow(()-> new EntityNotFoundException("Program not found"));
        Application app = Application.builder()
                .student(user)
                .program(program)
                .applicationDate(LocalDate.now())
                .status("PENDING")
                .build();
        return applicationRepository.save(app);
    }

    @Override
    public List<Application> getByStudent(Long studentId) {
        return applicationRepository.findByStudentId(studentId);
    }
}