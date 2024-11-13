package br.com.ecommerce.repository;

import br.com.ecommerce.model.UsuarioModel;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
	@Query("SELECT u FROM UsuarioModel u JOIN FETCH u.role WHERE u.id = :id")
	Optional<UsuarioModel> findByIdWithRole(@Param("id") Long id);

}
