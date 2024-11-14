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
import pe.edu.upeu.portal.entity.Requisito_Encargado;
import pe.edu.upeu.portal.service.Requisito_EncargadoService;

@RestController
@RequestMapping("api/requisito_encargado")
@CrossOrigin(origins = "http://localhost:4200")
public class Requisito_EncargadoController {

    @Autowired
    private Requisito_EncargadoService requisitoEncargadoService;

    @GetMapping
    public ResponseEntity<List<Requisito_Encargado>> readAll() {
        try {
            List<Requisito_Encargado> requisitosEncargados = requisitoEncargadoService.readAll();
            if (requisitosEncargados.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(requisitosEncargados, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Requisito_Encargado> crear(@Valid @RequestBody Requisito_Encargado requisitoEncargado) {
        try {
            Requisito_Encargado r = requisitoEncargadoService.create(requisitoEncargado);
            return new ResponseEntity<>(r, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Requisito_Encargado> getRequisitoEncargadoById(@PathVariable("id") Long id) {
        try {
            Optional<Requisito_Encargado> r = requisitoEncargadoService.read(id);
            return r.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delRequisitoEncargado(@PathVariable("id") Long id) {
        try {
            requisitoEncargadoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Requisito_Encargado> updateRequisitoEncargado(@PathVariable("id") Long id, @Valid @RequestBody Requisito_Encargado requisitoEncargado) {
        Optional<Requisito_Encargado> existingRequisitoEncargado = requisitoEncargadoService.read(id);
        if (existingRequisitoEncargado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(requisitoEncargadoService.update(requisitoEncargado), HttpStatus.OK);
        }
    }
}
