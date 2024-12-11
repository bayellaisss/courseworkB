package kg.project.courseworkjava.repos;

import kg.project.courseworkjava.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramRepos extends JpaRepository<Program, Long> {
    List<Program> findByUniversityId(Long universityId);
}
