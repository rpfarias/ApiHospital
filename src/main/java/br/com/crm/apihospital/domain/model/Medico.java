package br.com.crm.apihospital.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medico {

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

    @NotBlank(message = "CRM é obrigatório")
    @Column(length = 11, unique = true)
    @JsonFormat(pattern = "12345/BA")
    private String crm;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date nascimento;

    @OneToMany(mappedBy = "medico", fetch = FetchType.LAZY)
    private List<Atendimento> atendimentos;
}
