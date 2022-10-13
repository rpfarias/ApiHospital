package br.com.crm.apihospital.domain.model;

import br.com.crm.apihospital.enumeration.StatusAtendimento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataAtendimento;

    private String observacao;

    @JsonValue
    @Enumerated(EnumType.STRING)
    private StatusAtendimento statusAtendimento;

//    @ToString.Exclude
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "paciente_id", updatable = false, insertable = false)
//    private Paciente paciente;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id", updatable = false, insertable = false)
    private Medico medico;

    @JsonManagedReference
    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_atendimento_paciente_rel",
            joinColumns = @JoinColumn(name = "atendimento_id"),
            inverseJoinColumns = @JoinColumn(name = "paciente_id"))
    private Set<Paciente> pacientes = new HashSet<>();
}
