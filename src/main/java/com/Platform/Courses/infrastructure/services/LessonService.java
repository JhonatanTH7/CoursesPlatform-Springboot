package com.Platform.Courses.infrastructure.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Platform.Courses.api.dto.request.LessonRequest;
import com.Platform.Courses.api.dto.request.update_request.UpdateLessonRequest;
import com.Platform.Courses.api.dto.response.assignment.AssignmentBasicResponse;
import com.Platform.Courses.api.dto.response.course.CourseBasicResponse;
import com.Platform.Courses.api.dto.response.lesson.LessonResponse;
import com.Platform.Courses.domain.entities.Assignment;
import com.Platform.Courses.domain.entities.Lesson;
import com.Platform.Courses.domain.repositories.CourseRepository;
import com.Platform.Courses.domain.repositories.LessonRepository;
import com.Platform.Courses.infrastructure.abstract_services.ILessonService;
import com.Platform.Courses.infrastructure.helpers.EntityToEntity;
import com.Platform.Courses.util.exceptions.ResourceNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LessonService implements ILessonService {

    @Autowired
    private final LessonRepository lessonRepository;

    @Autowired
    private final CourseRepository courseRepository;

    @Override
    public LessonResponse getById(Long id) {
        return entityToResponse(this.find(id));
    }

    @Override
    public LessonResponse create(LessonRequest request) {
        Lesson lesson = EntityToEntity.entityToEntity(request, Lesson.class);
        lesson.setCourse(this.courseRepository.findById(request.getIdCourse())
                .orElseThrow(() -> new ResourceNotFoundException("No course found with the id: " + request.getIdCourse())));
        lesson.setAssignments(new ArrayList<>());
        return entityToResponse(this.lessonRepository.save(lesson));
    }

    @Override
    public LessonResponse update(UpdateLessonRequest request, Long id) {
        Lesson oldLesson = find(id);
        Lesson lessonInfoUpdated = EntityToEntity.entityToEntity(request, Lesson.class);
        lessonInfoUpdated.setIdLesson(id);
        lessonInfoUpdated.setAssignments(oldLesson.getAssignments());
        lessonInfoUpdated.setCourse(oldLesson.getCourse());
        return this.entityToResponse(this.lessonRepository.save(lessonInfoUpdated));
    }

    @Override
    public void delete(Long id) {
        this.lessonRepository.delete(this.find(id));
    }

    @Override
    public List<AssignmentBasicResponse> getAllAssignmentsByLessonId(Long id) {
        return this.find(id).getAssignments().stream().map(this::assignmentToResponse).toList();
    }

    private Lesson find(Long id) {
        return this.lessonRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No lesson found with the id: " + id));
    }

    private LessonResponse entityToResponse(Lesson entity) {
        List<AssignmentBasicResponse> assignments = entity.getAssignments().stream().map(this::assignmentToResponse)
                .toList();
        LessonResponse lessonResponse = EntityToEntity.entityToEntity(entity, LessonResponse.class);
        lessonResponse.setAssignments(assignments);
        lessonResponse.setCourse(EntityToEntity.entityToEntity(entity.getCourse(), CourseBasicResponse.class));
        lessonResponse.getCourse()
                .setInstructor(EntityToEntity.userToBasicResponse(entity.getCourse().getInstructor()));
        return lessonResponse;
    }

    private AssignmentBasicResponse assignmentToResponse(Assignment entity) {
        return EntityToEntity.entityToEntity(entity, AssignmentBasicResponse.class);
    }

}
