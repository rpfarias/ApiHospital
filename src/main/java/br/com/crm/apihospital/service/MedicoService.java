package br.com.crm.apihospital.service;

import br.com.crm.apihospital.domain.model.Medico;
import br.com.crm.apihospital.domain.model.Users;
import br.com.crm.apihospital.repository.MedicoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
        Optional<Medico> verificarCpf = medicoRepository.findByCpf(medico.getCpf());
        if (!verificarCpf.isPresent()) {
            Medico newMedico = new Medico();
            newMedico.setNome(medico.getNome());
            newMedico.setCpf(medico.getCpf());
            newMedico.setCrm(medico.getCrm().toUpperCase());
            newMedico.setNascimento(medico.getNascimento());
            return medicoRepository.save(medico);
        } else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("CPF { %s } já cadastrado.", medico.getCpf()));
    }

    public Medico update(Medico medico, Long id) {
        Medico updateMedico = medicoRepository.findById(id).get();
        updateMedico.setNome(medico.getNome());
        updateMedico.setCpf(medico.getCpf());
        updateMedico.setCrm(medico.getCrm().toUpperCase());
        updateMedico.setNascimento(medico.getNascimento());
        return medicoRepository.save(updateMedico);
    }

    public void deleteById(Long id) {
        medicoRepository.deleteById(id);
    }
}
