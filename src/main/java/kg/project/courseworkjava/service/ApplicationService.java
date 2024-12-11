package kg.project.courseworkjava.service;

import kg.project.courseworkjava.entity.Application;
import kg.project.courseworkjava.entity.Program;

import java.util.List;

public interface ApplicationService {
    Application createApplication(Long userId, Long programId);
    List<Application> getByStudent(Long studentId);

    public Program getProgram(Long programId);

}
