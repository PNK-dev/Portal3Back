package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.RolPrivilegios;

public interface RolPrivilegiosService {
    RolPrivilegios create(RolPrivilegios r);
    RolPrivilegios update(RolPrivilegios r);
    Optional<RolPrivilegios> read(Long id);
    void delete(Long id);
    List<RolPrivilegios> readAll();
}
