package br.com.crm.apihospital.controller;

import br.com.crm.apihospital.domain.model.Atendimento;
import br.com.crm.apihospital.service.AtendimentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/atendimentos")
public class AtendimentoController {

    private AtendimentoService atendimentoService;

    @GetMapping
    public List<Atendimento> listaAtendimento() {
        return atendimentoService.findAll();
    }

    @GetMapping("/{id}")
    public Atendimento findById(@PathVariable Long id) {
        return atendimentoService.findById(id);
    }

    @PostMapping
    public Atendimento create(Atendimento atendimento) {
        return atendimentoService.create(atendimento);
    }

    @PutMapping("/{id}")
    public Atendimento update(@PathVariable Long id, @RequestBody Atendimento atendimento) {
        return atendimentoService.create(atendimento);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        atendimentoService.deleteById(id);
    }
}
