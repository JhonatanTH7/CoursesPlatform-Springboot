package com.Platform.Courses.infrastructure.abstract_services;

import com.Platform.Courses.api.dto.request.AssignmentRequest;
import com.Platform.Courses.api.dto.request.update_request.UpdateAssignmentRequest;
import com.Platform.Courses.api.dto.response.AssignmentResponse;

public interface IAssignmentService
        extends CrudService<AssignmentRequest, UpdateAssignmentRequest, AssignmentResponse, Long> {

}
