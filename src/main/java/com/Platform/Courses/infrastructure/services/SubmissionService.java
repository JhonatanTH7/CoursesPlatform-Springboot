package com.Platform.Courses.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Platform.Courses.api.dto.request.SubmissionRequest;
import com.Platform.Courses.api.dto.request.update_request.UpdateSubmissionRequest;
import com.Platform.Courses.api.dto.response.assignment.AssignmentBasicResponse;
import com.Platform.Courses.api.dto.response.submission.SubmissionResponse;
import com.Platform.Courses.domain.entities.Submission;
import com.Platform.Courses.domain.repositories.AssignmentRepository;
import com.Platform.Courses.domain.repositories.SubmissionRepository;
import com.Platform.Courses.domain.repositories.UserRepository;
import com.Platform.Courses.infrastructure.abstract_services.ISubmissionService;
import com.Platform.Courses.infrastructure.helpers.EntityToEntity;
import com.Platform.Courses.util.exceptions.ResourceNotFound;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubmissionService implements ISubmissionService {

    @Autowired
    private final SubmissionRepository submissionRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final AssignmentRepository assignmentRepository;

    @Override
    public SubmissionResponse getById(Long id) {
        return this.entityToResponse(this.find(id));
    }

    @Override
    public SubmissionResponse create(SubmissionRequest request) {
        Submission submission = EntityToEntity.entityToEntity(request, Submission.class);
        submission.setAssignment(this.assignmentRepository.findById(request.getIdAssignment()).orElseThrow(
                () -> new ResourceNotFound("No assignment found with the id: " + request.getIdAssignment())));
        submission.setStudent(this.userRepository.findById(request.getIdStudent())
                .orElseThrow(() -> new ResourceNotFound("No student found with the id: " + request.getIdStudent())));
        return this.entityToResponse(this.submissionRepository.save(submission));
    }

    @Override
    public SubmissionResponse update(UpdateSubmissionRequest request, Long id) {
        Submission oldSubmission = this.find(id);
        Submission submissionInfoUpdated = EntityToEntity.entityToEntity(request, Submission.class);
        submissionInfoUpdated.setIdSubmission(id);
        submissionInfoUpdated.setSubmissionDate(oldSubmission.getSubmissionDate());
        submissionInfoUpdated.setAssignment(oldSubmission.getAssignment());
        submissionInfoUpdated.setStudent(oldSubmission.getStudent());
        return this.entityToResponse(this.submissionRepository.save(submissionInfoUpdated));
    }

    @Override
    public void delete(Long id) {
        this.submissionRepository.delete(find(id));
    }

    private Submission find(Long id) {
        return this.submissionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("No submission found with the id: " + id));
    }

    private SubmissionResponse entityToResponse(Submission entity) {
        SubmissionResponse submissionResponse = EntityToEntity.entityToEntity(entity, SubmissionResponse.class);
        submissionResponse.setStudent(EntityToEntity.userToBasicResponse(entity.getStudent()));
        submissionResponse
                .setAssignment(EntityToEntity.entityToEntity(entity.getAssignment(), AssignmentBasicResponse.class));
        return submissionResponse;
    }
}
