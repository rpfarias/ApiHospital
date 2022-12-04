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
public class ConsultationFilterRequest {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate initialDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate finalDate;
}
