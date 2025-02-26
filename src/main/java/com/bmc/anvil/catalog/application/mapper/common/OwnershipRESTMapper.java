package com.bmc.anvil.catalog.application.mapper.common;

import com.bmc.anvil.catalog.application.dto.OwnershipDTO;
import com.bmc.anvil.catalog.domain.model.valueobject.Ownership;

import org.mapstruct.Mapper;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
@Mapper(componentModel = "jakarta", uses = {IdMapper.class})
public interface OwnershipRESTMapper {

    Ownership fromDto(OwnershipDTO ownershipDTO);

}
