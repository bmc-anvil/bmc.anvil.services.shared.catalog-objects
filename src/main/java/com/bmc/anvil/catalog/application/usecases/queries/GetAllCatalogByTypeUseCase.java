package com.bmc.anvil.catalog.application.usecases.queries;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

import com.bmc.anvil.catalog.adapters.in.rest.dtos.responses.CatalogResponseDTO;
import com.bmc.anvil.catalog.adapters.in.rest.mappers.CatalogRestDTOMapper;
import com.bmc.anvil.catalog.application.ports.in.GetAllCatalogByTypeInputPort;
import com.bmc.anvil.catalog.application.ports.out.CatalogOutputPort;
import com.bmc.anvil.catalog.domain.models.CatalogType;
import com.bmc.anvil.catalog.infrastructure.logging.Logged;

import io.smallrye.mutiny.Uni;

import lombok.RequiredArgsConstructor;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
@Logged
@ApplicationScoped
@RequiredArgsConstructor
public class GetAllCatalogByTypeUseCase implements GetAllCatalogByTypeInputPort {

    private final CatalogOutputPort    outputPort;
    private final CatalogRestDTOMapper restMapper;

    @Override
    public Uni<List<CatalogResponseDTO>> execute(final CatalogType catalogType) {

        return outputPort.getAllByType(catalogType)
                         .map(catalogs -> catalogs.stream().map(restMapper::toResponseDto).toList());
    }

}
