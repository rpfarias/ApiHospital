package br.com.crm.apihospital.domain.response;

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
}
