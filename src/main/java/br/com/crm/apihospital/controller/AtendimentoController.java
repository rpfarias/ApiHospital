package br.com.crm.apihospital.controller;

import br.com.crm.apihospital.domain.model.Atendimento;
import br.com.crm.apihospital.domain.model.Medico;
import br.com.crm.apihospital.service.AtendimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/atendimentos")
public class AtendimentoController {

    private final AtendimentoService atendimentoService;

    public AtendimentoController(AtendimentoService atendimentoService) {
        this.atendimentoService = atendimentoService;
    }

    @GetMapping
    public List<Atendimento> findAll() {
//        return ResponseEntity.ok(atendimentoService.findAll()).getBody();
        return atendimentoService.findAll();
    }

    @GetMapping("/{id}")
    public Atendimento findById(@PathVariable Long id) {
        return ResponseEntity.ok(atendimentoService.findById(id)).getBody();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid Atendimento atendimento) {
        atendimentoService.create(atendimento);
        return ResponseEntity.status(HttpStatus.CREATED).body("Atendimento criado com sucesso");
    }

    @PutMapping("/{id}")
    public Atendimento update(@PathVariable Long id, @RequestBody @Valid Atendimento atendimento) {
        return atendimentoService.update(atendimento, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        atendimentoService.deleteById(id);
    }
}
