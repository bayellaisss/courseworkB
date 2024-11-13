package kg.project.courseworkjava.repos;

import kg.project.courseworkjava.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepos extends JpaRepository<Application, Long> {
}
