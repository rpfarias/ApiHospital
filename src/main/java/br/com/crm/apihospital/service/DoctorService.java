package br.com.crm.apihospital.service;

import br.com.crm.apihospital.domain.model.Doctor;
import br.com.crm.apihospital.domain.request.DoctorRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorService {

    List<Doctor> findAll();

    Doctor findById(Long id);

    Doctor create(DoctorRequest request);

    Doctor update(Long id, DoctorRequest request);

    void deleteById(Long id);
}
