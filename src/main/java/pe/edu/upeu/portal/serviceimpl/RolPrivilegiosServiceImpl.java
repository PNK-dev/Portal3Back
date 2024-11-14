package pe.edu.upeu.portal.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upeu.portal.entity.RolPrivilegios;
import pe.edu.upeu.portal.repository.RolPrivilegiosRepository;
import pe.edu.upeu.portal.service.RolPrivilegiosService;

@Service
public class RolPrivilegiosServiceImpl implements RolPrivilegiosService {

    @Autowired
    private RolPrivilegiosRepository rolPrivilegiosRepository;

    @Override
    public RolPrivilegios create(RolPrivilegios r) {
        return rolPrivilegiosRepository.save(r);
    }

    @Override
    public RolPrivilegios update(RolPrivilegios r) {
        return rolPrivilegiosRepository.save(r);
    }

    @Override
    public Optional<RolPrivilegios> read(Long id) {
        return rolPrivilegiosRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        rolPrivilegiosRepository.deleteById(id);
    }

    @Override
    public List<RolPrivilegios> readAll() {
        return rolPrivilegiosRepository.findAll();
    }
}
