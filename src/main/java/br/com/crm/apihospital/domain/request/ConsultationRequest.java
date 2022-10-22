package br.com.crm.apihospital.domain.request;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationRequest {

    private LocalDate consultationDate;
    private String observation;
    private Boolean isActive;

    @NotNull(message = "The field DoctorId is mandatory")
    private Long doctorId;

    @NotNull(message = "The field PatientId is mandatory")
    private Long patientId;
}
