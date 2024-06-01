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

import com.Platform.Courses.api.dto.request.AssignmentRequest;
import com.Platform.Courses.api.dto.request.update_request.UpdateAssignmentRequest;
import com.Platform.Courses.api.dto.response.assignment.AssignmentResponse;
import com.Platform.Courses.infrastructure.abstract_services.IAssignmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/assignment")
@AllArgsConstructor
public class AssignmentController {

    @Autowired
    private final IAssignmentService iAssignmentService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<AssignmentResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.iAssignmentService.getById(id));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<AssignmentResponse> create(
            @Validated @RequestBody AssignmentRequest request) {
        return ResponseEntity.ok(this.iAssignmentService.create(request));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.iAssignmentService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<AssignmentResponse> update(
            @Validated @RequestBody UpdateAssignmentRequest request,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.iAssignmentService.update(request, id));
    }

}
