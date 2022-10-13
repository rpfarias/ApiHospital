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
        var test = atendimentoRepository.findAll();
        return test;
    }

    public Atendimento findById(Long id) {
        return atendimentoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Atendimento { %s } not found ID.", id)));
    }

    public Atendimento create(Atendimento atendimento) {

        Atendimento newAtendimento = new Atendimento();
        newAtendimento.setMedico(atendimento.getMedico());
        newAtendimento.setPacientes(atendimento.getPacientes());
        newAtendimento.setStatusAtendimento(atendimento.getStatusAtendimento());
        newAtendimento.setObservacao(atendimento.getObservacao());
        newAtendimento.setDataAtendimento(atendimento.getDataAtendimento());
        return atendimentoRepository.save(atendimento);
    }

    public Atendimento update(Atendimento atendimento, Long id) {
        Atendimento updatePaciente = atendimentoRepository.findById(id).get();
        updatePaciente.setObservacao(atendimento.getObservacao());
        updatePaciente.setDataAtendimento(atendimento.getDataAtendimento());
        updatePaciente.setStatusAtendimento(atendimento.getStatusAtendimento());
        return atendimentoRepository.save(updatePaciente);
    }

    public void deleteById(Long id) {
        atendimentoRepository.deleteById(id);
    }

}
