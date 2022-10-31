package br.com.crm.apihospital.service.impl;

import br.com.crm.apihospital.domain.model.Patient;
import br.com.crm.apihospital.domain.request.PatientRequest;
import br.com.crm.apihospital.repository.PatientRepository;
import br.com.crm.apihospital.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static br.com.crm.apihospital.domain.converters.PatientConverter.mergeRequestIntoPatient;
import static br.com.crm.apihospital.domain.converters.PatientConverter.toPatient;

@Slf4j
@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(final PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> findAll() {
        log.info("Trying to get all patients");

        return patientRepository.findAll();
    }

    @Override
    public Patient findById(Long id) {
        log.info(String.format("Trying to get a patient by id { %s }", id));

        return patientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Patient { %s } not found.", id)));
    }

    @Override
    public Patient create(PatientRequest request) {
        log.info(String.format("Trying to create a new patient %s ", request.toString()));

        if (!verifyCPF(request.getCpf())) {
            Patient patient = toPatient(request);
            return patientRepository.saveAndFlush(patient);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("The CPF { %s } entered already belongs to another user.", request.getCpf()));
        }
    }

    @Override
    public Patient update(Long id, PatientRequest request) {
        log.info(String.format("Trying to update a patient %s ", request.toString()));

        Patient patient = this.findById(id);
        mergeRequestIntoPatient(request, patient);
        return patientRepository.saveAndFlush(patient);
    }

    @Override
    public void deleteById(Long id) {
        log.info(String.format("Trying to delete a patient by id { %s }", id));

        patientRepository.deleteById(id);
    }

    private boolean verifyCPF(String cpf) {
        return patientRepository.findByCpf(cpf).isPresent();
    }
}
