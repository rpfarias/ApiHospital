package br.com.crm.apihospital.controller;

import br.com.crm.apihospital.domain.model.Atendimento;
import br.com.crm.apihospital.service.AtendimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/atendimentos")
public class AtendimentoController {

    private final AtendimentoService atendimentoService;

    public AtendimentoController(AtendimentoService atendimentoService) {
        this.atendimentoService = atendimentoService;
    }

    @GetMapping
    public List<Atendimento> listaAtendimento() {
        return atendimentoService.findAll();
    }

    @GetMapping("/{id}")
    public Atendimento findById(@PathVariable Long id) {
        return atendimentoService.findById(id);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Atendimento atendimento) {
        atendimentoService.create(atendimento);
        return ResponseEntity.status(HttpStatus.CREATED).body("Atendimento criado com sucesso");
    }

    @PutMapping("/{id}")
    public Atendimento update(@PathVariable Long id, @RequestBody Atendimento atendimento) {
        return atendimentoService.update(atendimento);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        atendimentoService.deleteById(id);
    }
}
