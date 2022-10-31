package br.com.crm.apihospital.service;

import br.com.crm.apihospital.domain.model.Consultation;
import br.com.crm.apihospital.domain.request.ConsultationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConsultationService {

    Consultation create(ConsultationRequest request);
    List<Consultation> findAll();

    Consultation findById(Long id);

    Consultation update(Long id, ConsultationRequest request);

    void deleteById(Long id);
}
