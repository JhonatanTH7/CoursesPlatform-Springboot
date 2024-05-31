package com.Platform.Courses.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Platform.Courses.api.dto.request.CourseRequest;
import com.Platform.Courses.api.dto.request.update_request.UpdateCourseRequest;
import com.Platform.Courses.api.dto.response.course.CourseResponse;
import com.Platform.Courses.api.dto.response.lesson.LessonBasicResponse;
import com.Platform.Courses.api.dto.response.message.MessageInCourseResponse;
import com.Platform.Courses.api.dto.response.user.UserBasicResponse;
import com.Platform.Courses.infrastructure.abstract_services.ICourseService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/course")
@AllArgsConstructor
public class CourseController {

    @Autowired
    private final ICourseService iCourseService;

    @GetMapping
    public ResponseEntity<Page<CourseResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(this.iCourseService.getAll(page - 1, size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CourseResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.iCourseService.getById(id));
    }

    @PostMapping(path = "/create")
    public ResponseEntity<CourseResponse> create(
            @Validated @RequestBody CourseRequest request) {
        return ResponseEntity.ok(this.iCourseService.create(request));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.iCourseService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<CourseResponse> update(
            @Validated @RequestBody UpdateCourseRequest request,
            @PathVariable Long id) {
        return ResponseEntity.ok(this.iCourseService.update(request, id));
    }

    @GetMapping(path = "/{id}/lessons")
    public ResponseEntity<List<LessonBasicResponse>> getAllLessons(@PathVariable Long id) {
        return ResponseEntity.ok(this.iCourseService.getAllLessonsByCourseId(id));
    }

    @GetMapping(path = "/{id}/messages")
    public ResponseEntity<List<MessageInCourseResponse>> getAllMessages(@PathVariable Long id) {
        return ResponseEntity.ok(this.iCourseService.getAllMessagesByCourseId(id));
    }

    @GetMapping(path = "/{id}/users")
    public ResponseEntity<List<UserBasicResponse>> getAllUsers(@PathVariable Long id) {
        return ResponseEntity.ok(this.iCourseService.getAllUsersByCourseId(id));
    }

}
