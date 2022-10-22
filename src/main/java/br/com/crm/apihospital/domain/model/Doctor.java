package br.com.crm.apihospital.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 11, unique = true)
    private String cpf;

    private String crm;

    private LocalDate birth;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
    private List<Consultation> consultations;
}
