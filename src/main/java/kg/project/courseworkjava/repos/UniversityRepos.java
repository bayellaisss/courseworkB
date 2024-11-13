package kg.project.courseworkjava.repos;

import kg.project.courseworkjava.entity.Role;
import kg.project.courseworkjava.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepos extends JpaRepository<University, Long> {
    University getByName(String name);
}
