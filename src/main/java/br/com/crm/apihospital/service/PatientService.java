package br.com.crm.apihospital.service;

import br.com.crm.apihospital.domain.model.Patient;
import br.com.crm.apihospital.domain.request.PatientRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {

    List<Patient> findAll();

    Patient findById(Long id);

    Patient create(PatientRequest request);

    Patient update(Long id, PatientRequest request);

    void deleteById(Long id);
}
