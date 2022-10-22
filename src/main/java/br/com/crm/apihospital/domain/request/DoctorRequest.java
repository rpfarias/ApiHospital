package br.com.crm.apihospital.domain.request;

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
public class DoctorRequest {

    @NotBlank(message = "The field Name is mandatory")
    @Size(min = 3, max = 50, message = "The Name field must contain between 3 and 50 characters")
    private String name;

    @CPF(message = "The field CPF is mandatory")
    private String cpf;

    @NotBlank(message = "The field CRM is mandatory")
    private String crm;

    @NotNull(message = "The field Birth is mandatory")
    private LocalDate birth;
}
