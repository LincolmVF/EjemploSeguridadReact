package seguridadreact.seguridadreact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seguridadreact.seguridadreact.entity.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


Optional<UserEntity> findByEmail(String email);

Boolean existsByEmail(String email);
}
