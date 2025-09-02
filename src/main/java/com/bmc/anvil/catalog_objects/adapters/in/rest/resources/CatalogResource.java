package com.bmc.anvil.catalog_objects.adapters.in.rest.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Request;
import jakarta.ws.rs.core.Response;

import com.bmc.anvil.catalog_objects.adapters.in.rest.dtos.requests.CatalogCreateDTO;
import com.bmc.anvil.catalog_objects.application.ports.in.CreateCatalogInputPort;
import com.bmc.anvil.catalog_objects.application.ports.in.GetAllCatalogByTypeInputPort;
import com.bmc.anvil.catalog_objects.domain.models.CatalogType;
import com.bmc.anvil.catalog_objects.infrastructure.logging.Logged;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;

import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import lombok.RequiredArgsConstructor;

import static jakarta.ws.rs.core.Response.ok;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
@Logged
@Path("/catalog")
@Produces("application/json")
@Consumes("application/json")
@RequiredArgsConstructor
public class CatalogResource {

    private final CreateCatalogInputPort       createCatalogInputPort;
    private final GetAllCatalogByTypeInputPort getAllForTypeInputPort;

    @POST
    public Uni<Response> create(final CatalogCreateDTO createCatalogDTO) {

        return createCatalogInputPort.execute(createCatalogDTO)
                                     .map(responseDto -> ok(responseDto).build());
    }

    @GET
    @Path("/{catalogType}")
    public Uni<Response> getAllForType(final @PathParam("catalogType") CatalogType catalogType) {

        return getAllForTypeInputPort.execute(catalogType)
                                     .map(responseDto -> ok(responseDto).build());
    }

    @ServerExceptionMapper(Exception.class)
    public Response handleIllegalArgumentException(Exception e) {

        Log.error("error BAD REQUEST", e);
        e.printStackTrace();
        return Response.status(Response.Status.BAD_REQUEST)
                       .entity(e.getMessage())
                       .build();
    }

    @ServerExceptionMapper(IllegalArgumentException.class)
    public Response handleIllegalArgumentException(IllegalArgumentException e) {

        Log.error("error BAD REQUEST", e);
        return Response.status(Response.Status.BAD_REQUEST)
                       .entity(e.getMessage())
                       .build();
    }

    @ServerExceptionMapper(NotFoundException.class)
    public Response handleNotFoundException(NotFoundException e, Request request) {

        Log.error("error BAD REQUEST", e);

        return Response.status(Response.Status.BAD_REQUEST)
                       .entity(e.getCause()
                                .getMessage())
                       .build();
    }

}
