package br.com.crm.apihospital.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_consultation")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate consultationDate;
    private String observation;
    private Boolean isActive;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", updatable = false, insertable = false)
    private Doctor doctor;

    @Column(name = "doctor_id", updatable = true, insertable = true)
    private Long doctorId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", updatable = false, insertable = false)
    private Patient patient;

    @Column(name = "patient_id", updatable = true, insertable = true)
    private Long patientId;
}
