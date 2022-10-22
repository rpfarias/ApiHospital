package br.com.crm.apihospital.controller;

import br.com.crm.apihospital.controller.helper.BaseController;
import br.com.crm.apihospital.domain.request.DoctorRequest;
import br.com.crm.apihospital.domain.response.DoctorResponse;
import br.com.crm.apihospital.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static br.com.crm.apihospital.domain.converters.DoctorConverter.toDoctorResponse;
import static br.com.crm.apihospital.domain.converters.DoctorConverter.toDoctorResponseList;

@RestController
@RequestMapping(value = "/api/doctors")
public class DoctorController extends BaseController {

    private final DoctorService doctorService;

    public DoctorController(final DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public ResponseEntity<List<DoctorResponse>> findAll() {
        return Optional
                .ofNullable(doctorService.findAll())
                .map(m -> ResponseEntity.ok().body(toDoctorResponseList(m)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponse> findById(@PathVariable Long id) {
        return Optional
                .ofNullable(doctorService.findById(id))
                .map(m -> ResponseEntity.ok().body(toDoctorResponse(m)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DoctorResponse> create(@RequestBody @Valid DoctorRequest request) {
        return Optional
                .ofNullable(doctorService.create(request))
                .map(m -> ResponseEntity.created(URI.create(String.format("/api/v1/doctors/%s", m.getId()))).body(toDoctorResponse(m)))
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponse> update(@PathVariable Long id, @RequestBody @Valid DoctorRequest request) {
        return Optional
                .ofNullable(doctorService.update(id, request))
                .map(m -> ResponseEntity.ok().body(toDoctorResponse(m)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        doctorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
