package pe.edu.upeu.portal.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.portal.entity.Requisito_Encargado;

public interface Requisito_EncargadoService {
    Requisito_Encargado create(Requisito_Encargado r);
    Requisito_Encargado update(Requisito_Encargado r);
    Optional<Requisito_Encargado> read(Long id);
    void delete(Long id);
    List<Requisito_Encargado> readAll();
}
