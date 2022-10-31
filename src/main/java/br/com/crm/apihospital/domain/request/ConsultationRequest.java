package br.com.crm.apihospital.domain.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationRequest {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate consultationDate;

    @Size(max = 100)
    private String observation;

    private Boolean isActive;

    @NotNull(message = "The field DoctorId is mandatory")
    private Long doctorId;

    @NotNull(message = "The field PatientId is mandatory")
    private Long patientId;
}
