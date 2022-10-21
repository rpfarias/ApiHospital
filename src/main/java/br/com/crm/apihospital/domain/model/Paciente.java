package br.com.crm.apihospital.domain.model;

import br.com.crm.apihospital.enumeration.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 50)
    private String nome;

    @NotBlank(message = "CPF é obrigatório")
    @Column(length = 11, unique = true)
    @CPF
    private String cpf;

//    @NotBlank(message = "Data de nascimento é obrigatório")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimento;

    @Column(nullable = false)
    @JsonValue
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    private List<Atendimento> atendimentos;
}
