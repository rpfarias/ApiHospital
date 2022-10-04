package br.com.crm.apihospital.service;

import br.com.crm.apihospital.domain.model.Medico;
import br.com.crm.apihospital.repository.MedicoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    public Medico findById(Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Medico { %s } not found ID.", id)));
    }

    public Medico create(Medico medico) {

        Medico newMedico = new Medico();
        newMedico.setNome(medico.getNome());
        newMedico.setCpf(medico.getCpf());
        newMedico.setCrm(medico.getCrm());
        newMedico.setNascimento(medico.getNascimento());
        newMedico.setAtendimentos(medico.getAtendimentos());
        return medicoRepository.save(medico);
    }

    public Medico update(Medico medico, Long id) {
        return medicoRepository.save(medico);
    }

    public void deleteById(Long id) {
        medicoRepository.deleteById(id);
    }
}
