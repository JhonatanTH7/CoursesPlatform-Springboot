package com.Platform.Courses.api.controllers;

import java.util.List;

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

import com.Platform.Courses.api.dto.request.LessonRequest;
import com.Platform.Courses.api.dto.request.update_request.UpdateLessonRequest;
import com.Platform.Courses.api.dto.response.AssignmentBasicResponse;
import com.Platform.Courses.api.dto.response.LessonResponse;
import com.Platform.Courses.infrastructure.abstract_services.ILessonService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/lesson")
@AllArgsConstructor
public class LessonController {

    @Autowired
    private final ILessonService iLessonService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<LessonResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.iLessonService.getById(id));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<LessonResponse> create(
            @Validated @RequestBody LessonRequest request) {
        return ResponseEntity.ok(this.iLessonService.create(request));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.iLessonService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<LessonResponse> update(
            @Validated @RequestBody UpdateLessonRequest request,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.iLessonService.update(request, id));
    }

    @GetMapping(path = "/{id}/assignments")
    public ResponseEntity<List<AssignmentBasicResponse>> getAllUsers(@PathVariable Long id) {
        return ResponseEntity.ok(this.iLessonService.getAllAssignmentsByLessonId(id));
    }
}
