package pe.edu.upeu.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upeu.portal.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
