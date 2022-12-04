package br.com.crm.apihospital.domain.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationRequest {

    private LocalDate consultationDate;
//    private LocalDate initialDate;
//    private LocalDate finalDate;

    @Size(max = 100)
    private String observation;

    private Boolean isActive;

    @NotNull(message = "The field DoctorId is mandatory")
    private Long doctorId;

    @NotNull(message = "The field PatientId is mandatory")
    private Long patientId;
}
