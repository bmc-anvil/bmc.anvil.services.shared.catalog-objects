package com.bmc.anvil.catalog.adapters.in.rest.mappers;

import com.bmc.anvil.catalog.adapters.in.rest.dtos.requests.CatalogCreateDTO;
import com.bmc.anvil.catalog.adapters.in.rest.dtos.responses.CatalogResponseDTO;
import com.bmc.anvil.catalog.domain.models.entities.Catalog;
import com.bmc.anvil.catalog.infrastructure.config.mapper.QuarkusMapstructConfig;

import org.mapstruct.Mapper;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 * I input
 * D domain
 */
@Mapper(config = QuarkusMapstructConfig.class)
public interface CatalogRestDTOMapper {

    Catalog fromCreateDto(CatalogCreateDTO createDTO);

    CatalogResponseDTO toResponseDto(Catalog catalog);

}
