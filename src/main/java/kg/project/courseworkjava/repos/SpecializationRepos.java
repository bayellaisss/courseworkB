package kg.project.courseworkjava.repos;

import kg.project.courseworkjava.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializationRepos extends JpaRepository<Specialization, Long> {
}
