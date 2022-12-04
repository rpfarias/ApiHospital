package br.com.crm.apihospital.domain.converters;

import br.com.crm.apihospital.domain.model.Consultation;
import br.com.crm.apihospital.domain.request.ConsultationFilterRequest;
import br.com.crm.apihospital.domain.request.ConsultationRequest;
import br.com.crm.apihospital.domain.response.ConsultationFilterResponse;
import br.com.crm.apihospital.domain.response.ConsultationResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        response.setDoctorId(consultation.getDoctorId());
        response.setPatientId(consultation.getPatientId());
//        response.setDoctor(consultation.getDoctor());
//        response.setPatient(consultation.getPatient());
        return response;
    }

    public static ConsultationFilterResponse toConsultationFilterResponse(Consultation consultation) {
        ConsultationFilterResponse responseFilter = new ConsultationFilterResponse();
        responseFilter.setId(consultation.getId());
        responseFilter.setConsultationDate(consultation.getConsultationDate());
        responseFilter.setObservation(consultation.getObservation());
        responseFilter.setIsActive(consultation.getIsActive());
        responseFilter.setDoctorId(consultation.getDoctorId());
        responseFilter.setPatientId(consultation.getPatientId());
//        response.setDoctor(consultation.getDoctor());
//        response.setPatient(consultation.getPatient());
        return responseFilter;
    }

//    public static List<ConsultationFilterResponse> toConsultationFilterResponseList(List<ConsultationFilterResponse> consultation) {
//        return consultation.stream().map(ConsultationConverter::toConsultationFilterResponse).collect(Collectors.toList());
//    }

    public static List<ConsultationResponse> toConsultationResponseList(List<Consultation> consultation) {// correto
        return consultation.stream().map(ConsultationConverter::toConsultationResponse).collect(Collectors.toList());
    }

    public static void mergeRequestIntoConsultation(ConsultationRequest request, Consultation consultation) {
        if (!StringUtils.isBlank(request.getConsultationDate().toString())) consultation.setConsultationDate(request.getConsultationDate());
        if (!StringUtils.isBlank(request.getObservation())) consultation.setObservation(request.getObservation());
        if (request.getDoctorId() != null) consultation.setDoctorId(request.getDoctorId());
        if (request.getPatientId() != null) consultation.setPatientId(request.getPatientId());
    }
}
