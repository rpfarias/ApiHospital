package br.com.crm.apihospital.domain.model;

import br.com.crm.apihospital.enumeration.StatusAtendimento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

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

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", updatable = false, insertable = false)
    private Paciente paciente;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id", updatable = false, insertable = false)
    private Medico medico;
}
