package br.com.crm.apihospital.service.impl;

import br.com.crm.apihospital.domain.model.Doctor;
import br.com.crm.apihospital.domain.request.DoctorRequest;
import br.com.crm.apihospital.repository.DoctorRepository;
import br.com.crm.apihospital.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static br.com.crm.apihospital.domain.converters.DoctorConverter.mergeRequestIntoDoctor;
import static br.com.crm.apihospital.domain.converters.DoctorConverter.toDoctor;

@Slf4j
@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(final DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> findAll() {
        log.info("Trying to get all the doctors");

        return doctorRepository.findAll();
    }

    @Override
    public Doctor findById(Long id) {
        log.info(String.format("Trying to get a doctor by id { %s }", id));

        return doctorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Doctor { %s } not found.", id)));
    }

    @Override
    public Doctor create(DoctorRequest request) {
        log.info(String.format("Trying to create a new doctor %s ", request.toString()));

        if (!verifyCPF(request.getCpf())) {
            Doctor doctor = toDoctor(request);
            return doctorRepository.saveAndFlush(doctor);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    String.format("The CPF { %s } entered already belongs to another user.", request.getCpf()));
        }
    }

    @Override
    public Doctor update(Long id, DoctorRequest request) {
        log.info(String.format("Trying to update a doctor %s ", request.toString()));

        Doctor doctor = this.findById(id);
        mergeRequestIntoDoctor(request, doctor);
        return doctorRepository.saveAndFlush(doctor);
    }

    @Override
    public void deleteById(Long id) {
        log.info(String.format("Trying to delete a doctor by id { %s }", id));

        doctorRepository.deleteById(id);
    }

    private boolean verifyCPF(String cpf) {
        return doctorRepository.findByCpf(cpf).isPresent();
    }
}
