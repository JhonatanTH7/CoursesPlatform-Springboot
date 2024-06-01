package com.Platform.Courses.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Platform.Courses.api.dto.request.SubmissionRequest;
import com.Platform.Courses.api.dto.request.update_request.UpdateSubmissionRequest;
import com.Platform.Courses.api.dto.response.submission.SubmissionResponse;
import com.Platform.Courses.infrastructure.abstract_services.ISubmissionService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/submission")
@AllArgsConstructor
public class SubmissionController {

    @Autowired
    private final ISubmissionService iSubmissionService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<SubmissionResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.iSubmissionService.getById(id));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<SubmissionResponse> create(
            @Validated @RequestBody SubmissionRequest request) {
        return ResponseEntity.ok(this.iSubmissionService.create(request));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.iSubmissionService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<SubmissionResponse> update(
            @Validated @RequestBody UpdateSubmissionRequest request,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.iSubmissionService.update(request, id));
    }
}
