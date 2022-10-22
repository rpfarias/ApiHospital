package br.com.crm.apihospital.service.impl;

import br.com.crm.apihospital.domain.model.Consultation;
import br.com.crm.apihospital.domain.model.Doctor;
import br.com.crm.apihospital.domain.model.Patient;
import br.com.crm.apihospital.domain.request.ConsultationRequest;
import br.com.crm.apihospital.repository.ConsultationRepository;
import br.com.crm.apihospital.service.ConsultationService;
import br.com.crm.apihospital.service.DoctorService;
import br.com.crm.apihospital.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static br.com.crm.apihospital.domain.converters.ConsultationConverter.toConsultation;

@Slf4j
@Service
public class ConsultationServiceImpl implements ConsultationService {

    private final ConsultationRepository consultationRepository;
    private final DoctorService doctorService;
    private final PatientService patientService;

    public ConsultationServiceImpl(final ConsultationRepository consultationRepository,
                                   final DoctorService doctorService,
                                   final PatientService patientService) {
        this.consultationRepository = consultationRepository;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @Override
    public Consultation create(ConsultationRequest request) {
        log.info(String.format("Trying to create a new consultation %s ", request.toString()));

        Doctor doctor = doctorService.findById(request.getDoctorId());
        Patient patient = patientService.findById(request.getPatientId());

        Consultation consultation = toConsultation(request);
        consultation.setDoctorId(doctor.getId());
        consultation.setPatientId(patient.getId());
        return consultationRepository.saveAndFlush(consultation);
    }
}
