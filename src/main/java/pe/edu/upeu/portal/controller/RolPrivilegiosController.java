package pe.edu.upeu.portal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.portal.jakarta.validation.Valid;
import pe.edu.upeu.portal.entity.RolPrivilegios;
import pe.edu.upeu.portal.service.RolPrivilegiosService;

@RestController
@RequestMapping("api/rolprivilegios")
@CrossOrigin(origins = "http://localhost:4200")
public class RolPrivilegiosController {

    @Autowired
    private RolPrivilegiosService rolPrivilegiosService;

    @GetMapping
    public ResponseEntity<List<RolPrivilegios>> readAll() {
        try {
            List<RolPrivilegios> rolPrivilegiosList = rolPrivilegiosService.readAll();
            if (rolPrivilegiosList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(rolPrivilegiosList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<RolPrivilegios> crear(@Valid @RequestBody RolPrivilegios rolPrivilegios) {
        try {
            RolPrivilegios rp = rolPrivilegiosService.create(rolPrivilegios);
            return new ResponseEntity<>(rp, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolPrivilegios> getRolPrivilegiosById(@PathVariable("id") Long id) {
        try {
            Optional<RolPrivilegios> rp = rolPrivilegiosService.read(id);
            return rp.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delRolPrivilegios(@PathVariable("id") Long id) {
        try {
            rolPrivilegiosService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolPrivilegios> updateRolPrivilegios(@PathVariable("id") Long id, @Valid @RequestBody RolPrivilegios rolPrivilegios) {
        Optional<RolPrivilegios> existingRolPrivilegios = rolPrivilegiosService.read(id);
        if (existingRolPrivilegios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(rolPrivilegiosService.update(rolPrivilegios), HttpStatus.OK);
        }
    }
}
