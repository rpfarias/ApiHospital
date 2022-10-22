package br.com.crm.apihospital.controller;

import br.com.crm.apihospital.controller.helper.BaseController;
import br.com.crm.apihospital.domain.request.ConsultationRequest;
import br.com.crm.apihospital.domain.response.ConsultationResponse;
import br.com.crm.apihospital.service.ConsultationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

import static br.com.crm.apihospital.domain.converters.ConsultationConverter.toConsultationResponse;

@RestController
@RequestMapping(value = "/api/consultations")
public class ConsultationController extends BaseController {

    private final ConsultationService consultationService;

    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @PostMapping
    public ResponseEntity<ConsultationResponse> create(@RequestBody @Valid ConsultationRequest request) {
        return Optional
                .ofNullable(consultationService.create(request))
                .map(m -> ResponseEntity.created(URI.create(String.format("/api/v1/consultations/%s", m.getId()))).body(toConsultationResponse(m)))
                .orElse(ResponseEntity.badRequest().build());
    }
}
