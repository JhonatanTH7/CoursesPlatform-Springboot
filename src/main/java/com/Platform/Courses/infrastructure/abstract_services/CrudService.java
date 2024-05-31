package com.Platform.Courses.infrastructure.abstract_services;

public interface CrudService<REQUEST, UPDATEREQUEST, RESPONSE, TYPE> {

    RESPONSE getById(TYPE id);

    RESPONSE create(REQUEST request);

    RESPONSE update(UPDATEREQUEST request, TYPE id);

    void delete(TYPE id);

}
