package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.Requisito_Encargado;
import pe.edu.upeu.portal.repository.Requisito_EncargadoRepository;
import pe.edu.upeu.portal.service.Requisito_EncargadoService;

@Service
public class Requisito_EncargadoServiceImpl implements Requisito_EncargadoService {

    @Autowired
    private Requisito_EncargadoRepository requisito_EncargadoRepository;

    @Override
    public Requisito_Encargado create(Requisito_Encargado r) {
        return requisito_EncargadoRepository.save(r);
    }

    @Override
    public Requisito_Encargado update(Requisito_Encargado r) {
        return requisito_EncargadoRepository.save(r);
    }

    @Override
    public Optional<Requisito_Encargado> read(Long id) {
        return requisito_EncargadoRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        requisito_EncargadoRepository.deleteById(id);
    }

    @Override
    public List<Requisito_Encargado> readAll() {
        return requisito_EncargadoRepository.findAll();
    }
}
