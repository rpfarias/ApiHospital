package br.com.crm.apihospital.service;

import br.com.crm.apihospital.domain.model.Paciente;
import br.com.crm.apihospital.repository.PacienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }

    public Paciente findById(Long id) {
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Paciente { %s } not found.", id)));
    }

    public Paciente create(Paciente paciente) {
        Optional<Paciente> verificarCpf = pacienteRepository.findByCpf(paciente.getCpf());
        if (!verificarCpf.isPresent()) {
            Paciente newPaciente = new Paciente();
            newPaciente.setNome(paciente.getNome());
            newPaciente.setCpf(paciente.getCpf());
            newPaciente.setSexo(paciente.getSexo());
            newPaciente.setNascimento(paciente.getNascimento());
            return pacienteRepository.save(paciente);
        } else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("CPF { %s } já cadastrado.", paciente.getCpf()));
    }

    public Paciente update(Paciente paciente, Long id) {
        Paciente updatePaciente = pacienteRepository.findById(id).get();
        updatePaciente.setNome(paciente.getNome());
        updatePaciente.setCpf(paciente.getCpf());
        updatePaciente.setSexo(paciente.getSexo());
        updatePaciente.setNascimento(paciente.getNascimento());
        return pacienteRepository.save(updatePaciente);
    }

    public void deleteById(Long id) {
        pacienteRepository.deleteById(id);
    }
}
