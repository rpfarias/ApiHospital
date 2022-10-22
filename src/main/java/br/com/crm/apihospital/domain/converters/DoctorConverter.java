package br.com.crm.apihospital.domain.converters;

import br.com.crm.apihospital.domain.model.Doctor;
import br.com.crm.apihospital.domain.request.DoctorRequest;
import br.com.crm.apihospital.domain.response.DoctorResponse;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class DoctorConverter {

    public static Doctor toDoctor(DoctorRequest request) {
        Doctor doctor = new Doctor();
        doctor.setName(request.getName());
        doctor.setCpf(request.getCpf());
        doctor.setCrm(request.getCrm());
        doctor.setBirth(request.getBirth());
        return doctor;
    }

    public static DoctorResponse toDoctorResponse(Doctor doctor) {
        DoctorResponse response = new DoctorResponse();
        response.setId(doctor.getId());
        response.setName(doctor.getName());
        response.setCpf(doctor.getCpf());
        response.setCrm(doctor.getCrm());
        response.setBirth(doctor.getBirth());
        return response;
    }

    public static List<DoctorResponse> toDoctorResponseList(List<Doctor> doctors) {
        return doctors.stream().map(DoctorConverter::toDoctorResponse).collect(Collectors.toList());
    }

    public static void mergeRequestIntoDoctor(DoctorRequest request, Doctor doctor) {
        if (!StringUtils.isBlank(request.getName())) doctor.setName(request.getName());
        if (!StringUtils.isBlank(request.getCpf())) doctor.setCpf(request.getCpf());
        if (request.getCrm() != null) doctor.setCrm(request.getCrm());
        if (request.getBirth() != null) doctor.setBirth(request.getBirth());
    }
}
