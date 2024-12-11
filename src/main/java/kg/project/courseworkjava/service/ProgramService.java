package kg.project.courseworkjava.service;

import kg.project.courseworkjava.entity.Program;

import java.util.List;

public interface ProgramService {
    List<Program> getProgramsByUniversity(Long universityId);
    Program getById(Long id);

}
