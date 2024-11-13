package kg.project.courseworkjava.repos;

import kg.project.courseworkjava.entity.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionRepos extends JpaRepository<RolePermission, Long> {
}
