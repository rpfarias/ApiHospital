package br.com.crm.apihospital.service;

import br.com.crm.apihospital.domain.model.Consultation;
import br.com.crm.apihospital.domain.request.ConsultationFilterRequest;
import br.com.crm.apihospital.domain.request.ConsultationRequest;
import br.com.crm.apihospital.domain.response.ConsultationResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface ConsultationService {

    Consultation create(ConsultationRequest request);
    List<Consultation> findAll();

    List<ConsultationResponse> findConsultationByPeriod(LocalDate initialDate, LocalDate finalDate);

    Consultation findById(Long id);

    Consultation update(Long id, ConsultationRequest request);

    void deleteById(Long id);
}
