package seguridadreact.seguridadreact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seguridadreact.seguridadreact.entity.RoleEntity;

import java.util.Optional;

/**
 * NUEVA CLASE: Repositorio para acceder a los roles en la base de datos
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    // Método para buscar un rol por su nombre
    Optional<RoleEntity> findByName(String name);
}