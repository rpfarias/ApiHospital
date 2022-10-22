package br.com.crm.apihospital.domain.converters;

import br.com.crm.apihospital.domain.model.Consultation;
import br.com.crm.apihospital.domain.request.ConsultationRequest;
import br.com.crm.apihospital.domain.response.ConsultationResponse;

public class ConsultationConverter {

    public static Consultation toConsultation(ConsultationRequest request) {
        Consultation consultation = new Consultation();
        consultation.setConsultationDate(request.getConsultationDate());
        consultation.setObservation(request.getObservation());
        consultation.setIsActive(request.getIsActive());
        return consultation;
    }

    public static ConsultationResponse toConsultationResponse(Consultation consultation) {
        ConsultationResponse response = new ConsultationResponse();
        response.setId(consultation.getId());
        response.setConsultationDate(consultation.getConsultationDate());
        response.setObservation(consultation.getObservation());
        response.setIsActive(consultation.getIsActive());
        return response;
    }
}
