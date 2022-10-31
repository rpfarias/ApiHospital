package br.com.crm.apihospital.domain.request;

import br.com.crm.apihospital.enumeration.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PatientRequest {

    @NotBlank(message = "The field Name is mandatory")
    @Size(min = 3, max = 50, message = "The Name field must contain between 3 and 50 characters")
    private String name;

    @CPF(message = "The field CPF is mandatory")
    private String cpf;

    @NotNull(message = "The field Birth is mandatory")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;

    @NotNull(message = "The field Gender is mandatory")
    private Gender gender;
}
