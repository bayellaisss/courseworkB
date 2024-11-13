package kg.project.courseworkjava.repos;

import kg.project.courseworkjava.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepos extends JpaRepository<Permission, Long> {
}
