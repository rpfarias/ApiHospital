package br.com.crm.apihospital.controller;

import br.com.crm.apihospital.controller.helper.BaseController;
import br.com.crm.apihospital.domain.request.PatientRequest;
import br.com.crm.apihospital.domain.response.PatientResponse;
import br.com.crm.apihospital.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static br.com.crm.apihospital.domain.converters.PatientConverter.toPatientResponse;
import static br.com.crm.apihospital.domain.converters.PatientConverter.toPatientResponseList;

@RestController
@RequestMapping(value = "/api/patients")
public class PacienteController extends BaseController {

    private final PatientService patientService;

    public PacienteController(final PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public ResponseEntity<List<PatientResponse>> findAll() {
        return Optional
                .ofNullable(patientService.findAll())
                .map(m -> ResponseEntity.ok().body(toPatientResponseList(m)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> findById(@PathVariable Long id) {
        return Optional
                .ofNullable(patientService.findById(id))
                .map(m -> ResponseEntity.ok().body(toPatientResponse(m)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PatientResponse> create(@RequestBody @Valid PatientRequest request) {
        return Optional
                .ofNullable(patientService.create(request))
                .map(m -> ResponseEntity.created(URI.create(String.format("/api/v1/patients/%s", m.getId()))).body(toPatientResponse(m)))
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> update(@PathVariable Long id, @RequestBody @Valid PatientRequest request) {
        return Optional
                .ofNullable(patientService.update(id, request))
                .map(m -> ResponseEntity.ok().body(toPatientResponse(m)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        patientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
