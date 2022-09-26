package br.com.crm.apihospital.domain.model;

import br.com.crm.apihospital.enumeration.StatusAtendimento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Data de atendimento é obrigatório")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAtendimento;

    private String observacao;

    @JsonValue
    @Enumerated(EnumType.STRING)
    private StatusAtendimento statusAtendimento;

    @OneToOne(mappedBy = "atendimento", fetch = FetchType.LAZY)
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
}
