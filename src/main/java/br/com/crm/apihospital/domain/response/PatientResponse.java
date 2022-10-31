package br.com.crm.apihospital.domain.response;

import br.com.crm.apihospital.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatientResponse {

    private Long id;
    private String name;
    private String cpf;
    private LocalDate birth;
    private Gender gender;
}
