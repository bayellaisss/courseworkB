package kg.project.courseworkjava.repos;

import kg.project.courseworkjava.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepos extends JpaRepository<Role, Long> {
    Role getByName(String name);
}
