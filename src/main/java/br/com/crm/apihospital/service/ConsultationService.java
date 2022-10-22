package br.com.crm.apihospital.service;

import br.com.crm.apihospital.domain.model.Consultation;
import br.com.crm.apihospital.domain.request.ConsultationRequest;

public interface ConsultationService {


    Consultation create(ConsultationRequest request);
}
