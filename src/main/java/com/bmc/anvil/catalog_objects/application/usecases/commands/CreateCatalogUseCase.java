package com.bmc.anvil.catalog_objects.application.usecases.commands;

import jakarta.enterprise.context.ApplicationScoped;

import com.bmc.anvil.catalog_objects.adapters.in.rest.dtos.requests.CatalogCreateDTO;
import com.bmc.anvil.catalog_objects.adapters.in.rest.dtos.responses.CatalogResponseDTO;
import com.bmc.anvil.catalog_objects.adapters.in.rest.mappers.CatalogRestDTOMapper;
import com.bmc.anvil.catalog_objects.application.ports.in.CreateCatalogInputPort;
import com.bmc.anvil.catalog_objects.application.ports.out.CatalogOutputPort;
import com.bmc.anvil.catalog_objects.infrastructure.logging.Logged;

import io.smallrye.mutiny.Uni;

import lombok.RequiredArgsConstructor;

import static io.smallrye.mutiny.Uni.createFrom;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
@Logged
@ApplicationScoped
@RequiredArgsConstructor
public class CreateCatalogUseCase implements CreateCatalogInputPort {

    private final CatalogOutputPort    outputPort;
    private final CatalogRestDTOMapper restMapper;

    @Override
    public Uni<CatalogResponseDTO> execute(final CatalogCreateDTO createCatalogDTO) {

        return createFrom().item(createCatalogDTO)
                           .map(restMapper::fromCreateDto)
                           .chain(outputPort::save)
                           .map(restMapper::toResponseDto);
    }

}
