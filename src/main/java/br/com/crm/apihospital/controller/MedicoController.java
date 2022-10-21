package br.com.crm.apihospital.controller;

import br.com.crm.apihospital.domain.model.Medico;
import br.com.crm.apihospital.service.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public List<Medico> findAll() {
        return medicoService.findAll();
    }

    @GetMapping("/{id}")
    public Medico findById(@PathVariable Long id) {
        return medicoService.findById(id);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid Medico medico) {
        medicoService.create(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body("Medico criado com sucesso");
    }

    @PutMapping("/{id}")
    public Medico update(@PathVariable Long id, @RequestBody @Valid Medico medico) {
        return medicoService.update(medico, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable ("id") Long id) {
        medicoService.deleteById(id);
    }
}
