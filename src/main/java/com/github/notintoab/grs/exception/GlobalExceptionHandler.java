package com.github.notintoab.grs.exception;

import java.util.Map;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<NotFoundOwnerException> {
    @Override
    public Response toResponse(NotFoundOwnerException exception) {
        Map<String, Object> errorResponse = Map.of(
            "status", Response.Status.NOT_FOUND.getStatusCode(),
            "message", exception.getMessage()
        );
        return Response.status(Response.Status.NOT_FOUND).entity(errorResponse).build();
    }
}
