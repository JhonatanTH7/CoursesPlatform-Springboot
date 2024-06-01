package com.Platform.Courses.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Platform.Courses.api.dto.request.EnrollmentRequest;
import com.Platform.Courses.api.dto.response.enrollment.EnrollmentResponse;
import com.Platform.Courses.infrastructure.abstract_services.IEnrollmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/enrollment")
@AllArgsConstructor
public class EnrollmentController {

    @Autowired
    private final IEnrollmentService iEnrollmentService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<EnrollmentResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.iEnrollmentService.getById(id));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<EnrollmentResponse> create(
            @Validated @RequestBody EnrollmentRequest request) {
        return ResponseEntity.ok(this.iEnrollmentService.create(request));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.iEnrollmentService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
