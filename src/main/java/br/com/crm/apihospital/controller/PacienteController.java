package br.com.crm.apihospital.controller;

import br.com.crm.apihospital.domain.model.Paciente;
import br.com.crm.apihospital.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<Paciente> findAll() {
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    public Paciente findById(@PathVariable Long id) {
        return pacienteService.findById(id);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Paciente paciente) {
        pacienteService.create(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body("Paciente criado com sucesso");
    }

    @PutMapping
    public Paciente update(@PathVariable Long id, @RequestBody Paciente paciente) {
        return pacienteService.update(paciente);
    }

    @DeleteMapping
    public void deleteById(@PathVariable Long id) {
        pacienteService.deleteById(id);
    }
}
