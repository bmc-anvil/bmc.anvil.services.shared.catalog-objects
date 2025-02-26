package com.bmc.anvil.catalog.application.mapper;

import com.bmc.anvil.catalog.application.dto.request.CatalogCreateDTO;
import com.bmc.anvil.catalog.application.dto.response.CatalogResponseDTO;
import com.bmc.anvil.catalog.domain.model.entity.Catalog;
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
