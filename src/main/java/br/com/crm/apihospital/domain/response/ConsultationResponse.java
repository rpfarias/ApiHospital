package br.com.crm.apihospital.domain.response;

import br.com.crm.apihospital.domain.model.Doctor;
import br.com.crm.apihospital.domain.model.Patient;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationResponse {

    private Long id;
    private LocalDate consultationDate;
    private String observation;
    private Boolean isActive;
    private Long doctorId;
    private Long patientId;
    private LocalDate initialDate;
    private LocalDate finalDate;
//  caso queira passar o objeto todo
//  private Doctor doctor;
//  private Patient patient;
}
