package br.com.crm.apihospital.service;

import br.com.crm.apihospital.domain.model.Atendimento;
import br.com.crm.apihospital.domain.model.Medico;
import br.com.crm.apihospital.repository.AtendimentoRepository;
import br.com.crm.apihospital.repository.MedicoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;
    private final MedicoRepository medicoRepository;

    public AtendimentoService(AtendimentoRepository atendimentoRepository, MedicoRepository medicoRepository) {
        this.atendimentoRepository = atendimentoRepository;
        this.medicoRepository = medicoRepository;
    }

    public List<Atendimento> findAll() {
        return atendimentoRepository.findAll();
    }

    public Atendimento findById(Long id) {
        return atendimentoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Atendimento { %s } not found ID.", id)));
    }

    public Atendimento create(Atendimento atendimento) {

        Atendimento newAtendimento = new Atendimento();

        newAtendimento.setMedico(atendimento.getMedico());
        newAtendimento.setPaciente(atendimento.getPaciente());
        newAtendimento.setObservacao(atendimento.getObservacao());
        newAtendimento.setDataAtendimento(atendimento.getDataAtendimento());
        return atendimentoRepository.save(atendimento);
    }

    public Atendimento update(Atendimento atendimento, Long id) {
        Atendimento updatePaciente = atendimentoRepository.findById(id).get();
        updatePaciente.setObservacao(atendimento.getObservacao());
        updatePaciente.setDataAtendimento(atendimento.getDataAtendimento());
        updatePaciente.setMedico(atendimento.getMedico());
        updatePaciente.setPaciente(atendimento.getPaciente());
        return atendimentoRepository.save(updatePaciente);
    }

    public void deleteById(Long id) {
        atendimentoRepository.deleteById(id);
    }
}
