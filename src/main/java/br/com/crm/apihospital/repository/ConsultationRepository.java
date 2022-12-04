package br.com.crm.apihospital.repository;

import br.com.crm.apihospital.domain.model.Consultation;
import br.com.crm.apihospital.domain.request.ConsultationFilterRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    @Query(
            "SELECT a FROM Consultation a WHERE a.consultationDate BETWEEN :initialDate AND :finalDate"
    )
    List<ConsultationFilterRequest> findConsultationByPeriod(
            @Param("dataInicio") LocalDate dataInicio,
            @Param("dataFim") LocalDate dataFim
    );
}
