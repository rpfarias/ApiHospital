package br.com.crm.apihospital.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Getter
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }
}
