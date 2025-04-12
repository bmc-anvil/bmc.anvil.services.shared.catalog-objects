package com.bmc.anvil.catalog.application.usecase.command;

import jakarta.enterprise.context.ApplicationScoped;

import com.bmc.anvil.catalog.application.dto.request.CatalogCreateDTO;
import com.bmc.anvil.catalog.application.dto.response.CatalogResponseDTO;
import com.bmc.anvil.catalog.application.mapper.CatalogRestDTOMapper;
import com.bmc.anvil.catalog.application.ports.in.CreateCatalogRESTInputPort;
import com.bmc.anvil.catalog.application.ports.out.CatalogOutputPort;
import com.bmc.anvil.catalog.infrastructure.logging.Logged;

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
public class CreateCatalogRESTUseCase implements CreateCatalogRESTInputPort {

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
