package br.com.crm.apihospital.service;

import br.com.crm.apihospital.domain.model.Atendimento;
import br.com.crm.apihospital.repository.AtendimentoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;

    public AtendimentoService(AtendimentoRepository atendimentoRepository) {
        this.atendimentoRepository = atendimentoRepository;
    }

    public List<Atendimento> findAll() {
        return atendimentoRepository.findAll();
    }

    public Atendimento findById(Long id) {
        return atendimentoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Atendimento { %s } not found ID.", id)));
    }

    public Atendimento create(Atendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    public Atendimento update(Atendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    public void deleteById(Long id) {
        atendimentoRepository.deleteById(id);
    }

}
