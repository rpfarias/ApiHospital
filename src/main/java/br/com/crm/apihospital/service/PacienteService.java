package br.com.crm.apihospital.service;

import br.com.crm.apihospital.domain.model.Paciente;
import br.com.crm.apihospital.repository.PacienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

        Paciente newPaciente = new Paciente();
        newPaciente.setNome(paciente.getNome());
        newPaciente.setCpf(newPaciente.getCpf());
        newPaciente.setSexo(paciente.getSexo());
        newPaciente.setNascimento(paciente.getNascimento());
        newPaciente.setAtendimentos(paciente.getAtendimentos());
        return pacienteRepository.save(paciente);
    }

    public Paciente update(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void deleteById(Long id) {
        pacienteRepository.deleteById(id);
    }
}
