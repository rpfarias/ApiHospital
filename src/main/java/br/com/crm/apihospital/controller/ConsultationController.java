package br.com.crm.apihospital.controller;

import br.com.crm.apihospital.controller.helper.BaseController;
import br.com.crm.apihospital.domain.request.ConsultationFilterRequest;
import br.com.crm.apihospital.domain.request.ConsultationRequest;
import br.com.crm.apihospital.domain.response.ConsultationFilterResponse;
import br.com.crm.apihospital.domain.response.ConsultationResponse;
import br.com.crm.apihospital.service.ConsultationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static br.com.crm.apihospital.domain.converters.ConsultationConverter.*;

@RestController
@RequestMapping(value = "/api/consultations")
public class ConsultationController extends BaseController {

    private final ConsultationService consultationService;

    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @GetMapping
    public ResponseEntity<List<ConsultationResponse>> findAll() {
        return Optional
                .ofNullable(consultationService.findAll())
                .map(m-> ResponseEntity.ok().body(toConsultationResponseList(m)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/findByPeriod/{initialDate}/{finalDate}") // 2022-10-20
    public ResponseEntity<List<ConsultationResponse>> findConsultationByPeriod(@PathVariable LocalDate initialDate, @PathVariable LocalDate finalDate) {
        return Optional
                .ofNullable(consultationService.findConsultationByPeriod(initialDate, finalDate))
                .map(m-> ResponseEntity.ok().body(toConsultationResponseList(m)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ConsultationResponse> create(@RequestBody @Valid ConsultationRequest request) {
        return Optional
                .ofNullable(consultationService.create(request))
                .map(m -> ResponseEntity.created(URI.create(String.format("/api/consultations/%s", m.getId()))).body(toConsultationResponse(m)))
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultationResponse> update(@PathVariable Long id, @RequestBody @Valid ConsultationRequest request) {
        return Optional
                .ofNullable(consultationService.update(id,request))
                .map(m -> ResponseEntity.ok().body(toConsultationResponse(m)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable ("id") Long id) {
        consultationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
