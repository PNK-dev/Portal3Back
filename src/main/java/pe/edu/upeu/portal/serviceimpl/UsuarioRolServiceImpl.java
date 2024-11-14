package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.UsuarioRol;
import pe.edu.upeu.portal.repository.UsuarioRolRepository;
import pe.edu.upeu.portal.service.UsuarioRolService;

@Service
public class UsuarioRolServiceImpl implements UsuarioRolService {

    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

    @Override
    public UsuarioRol create(UsuarioRol u) {
        return usuarioRolRepository.save(u);
    }

    @Override
    public UsuarioRol update(UsuarioRol u) {
        return usuarioRolRepository.save(u);
    }

    @Override
    public Optional<UsuarioRol> read(Long id) {
        return usuarioRolRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        usuarioRolRepository.deleteById(id);
    }

    @Override
    public List<UsuarioRol> readAll() {
        return usuarioRolRepository.findAll();
    }
}
