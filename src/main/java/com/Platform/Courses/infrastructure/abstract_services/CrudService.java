package com.Platform.Courses.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

public interface CrudService<REQUEST, UPDATEREQUEST, RESPONSE, TYPE> {

    Page<RESPONSE> getAll(int page, int size);

    RESPONSE getById(TYPE id);

    RESPONSE create(REQUEST request);

    RESPONSE update(UPDATEREQUEST request, TYPE id);

    void delete(TYPE id);

}
