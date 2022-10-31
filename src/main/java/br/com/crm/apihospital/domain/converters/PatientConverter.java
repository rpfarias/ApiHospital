package br.com.crm.apihospital.domain.converters;

import br.com.crm.apihospital.domain.model.Patient;
import br.com.crm.apihospital.domain.request.PatientRequest;
import br.com.crm.apihospital.domain.response.PatientResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class PatientConverter {

    public static Patient toPatient(PatientRequest request) {
        Patient patient = new Patient();
        patient.setName(request.getName());
        patient.setCpf(request.getCpf());
        patient.setGender(request.getGender());
        patient.setBirth(request.getBirth());
        return patient;
    }

    public static PatientResponse toPatientResponse(Patient patient) {
        PatientResponse response = new PatientResponse();
        response.setId(patient.getId());
        response.setName(patient.getName());
        response.setCpf(patient.getCpf());
        response.setGender(patient.getGender());
        response.setBirth(patient.getBirth());
        return response;
    }

    public static List<PatientResponse> toPatientResponseList(List<Patient> patients) {
        return patients.stream().map(PatientConverter::toPatientResponse).collect(Collectors.toList());
    }

    public static void mergeRequestIntoPatient(PatientRequest request, Patient patient) {
        if (!StringUtils.isBlank(request.getName())) patient.setName(request.getName());
        if (!StringUtils.isBlank(request.getCpf())) patient.setCpf(request.getCpf());
        if (request.getGender() != null) patient.setGender(request.getGender());
        if (request.getBirth() != null) patient.setBirth(request.getBirth());
    }
}
