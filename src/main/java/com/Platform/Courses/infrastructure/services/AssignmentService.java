package com.Platform.Courses.infrastructure.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Platform.Courses.api.dto.request.AssignmentRequest;
import com.Platform.Courses.api.dto.request.update_request.UpdateAssignmentRequest;
import com.Platform.Courses.api.dto.response.AssignmentResponse;
import com.Platform.Courses.api.dto.response.LessonInAssignmentResponse;
import com.Platform.Courses.api.dto.response.SubmissionInAssignmentResponse;
import com.Platform.Courses.domain.entities.Assignment;
import com.Platform.Courses.domain.entities.Lesson;
import com.Platform.Courses.domain.repositories.AssignmentRepository;
import com.Platform.Courses.domain.repositories.LessonRepository;
import com.Platform.Courses.infrastructure.abstract_services.IAssignmentService;
import com.Platform.Courses.infrastructure.helpers.EntityToEntity;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AssignmentService implements IAssignmentService {

    @Autowired
    private final AssignmentRepository assignmentRepository;

    @Autowired
    private final LessonRepository lessonRepository;

    @Override
    public AssignmentResponse getById(Long id) {
        return this.entityToResponse(this.find(id));
    }

    @Override
    public AssignmentResponse create(AssignmentRequest request) {
        Assignment assignment = EntityToEntity.entityToEntity(request, Assignment.class);
        Lesson lesson = this.lessonRepository.findById(request.getIdLesson()).orElseThrow();
        assignment.setLesson(lesson);
        assignment.setSubmissions(new ArrayList<>());
        return this.entityToResponse(this.assignmentRepository.save(assignment));
    }

    @Override
    public AssignmentResponse update(UpdateAssignmentRequest request, Long id) {
        Assignment oldAssignment = find(id);
        Assignment assignmentInfoUpdated = EntityToEntity.entityToEntity(request, Assignment.class);
        assignmentInfoUpdated.setIdAssignment(id);
        assignmentInfoUpdated.setLesson(oldAssignment.getLesson());
        assignmentInfoUpdated.setSubmissions(oldAssignment.getSubmissions());
        return this.entityToResponse(this.assignmentRepository.save(assignmentInfoUpdated));
    }

    @Override
    public void delete(Long id) {
        this.assignmentRepository.delete(find(id));
    }

    private Assignment find(Long id) {
        return this.assignmentRepository.findById(id).orElseThrow();
    }

    private AssignmentResponse entityToResponse(Assignment entity) {

        AssignmentResponse assignmentResponse = EntityToEntity.entityToEntity(entity, AssignmentResponse.class);

        assignmentResponse
                .setLesson(EntityToEntity.entityToEntity(entity.getLesson(), LessonInAssignmentResponse.class));
        assignmentResponse.getLesson().setIdCourse(entity.getLesson().getCourse().getIdCourse());

        assignmentResponse.setSubmissions(entity.getSubmissions().stream().map(submission -> {
            SubmissionInAssignmentResponse submissionInAssignmentResponse = EntityToEntity.entityToEntity(submission,
                    SubmissionInAssignmentResponse.class);
            submissionInAssignmentResponse.setStudent(EntityToEntity.userToBasicResponse(submission.getStudent()));
            return submissionInAssignmentResponse;
        }).toList());

        return assignmentResponse;
    }

}
