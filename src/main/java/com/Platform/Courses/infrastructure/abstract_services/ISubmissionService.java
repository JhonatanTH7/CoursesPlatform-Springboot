package com.Platform.Courses.infrastructure.abstract_services;

import org.springframework.stereotype.Service;

import com.Platform.Courses.api.dto.request.SubmissionRequest;
import com.Platform.Courses.api.dto.request.update_request.UpdateSubmissionRequest;
import com.Platform.Courses.api.dto.response.submission.SubmissionResponse;

@Service
public interface ISubmissionService
        extends CrudService<SubmissionRequest, UpdateSubmissionRequest, SubmissionResponse, Long> {

}
