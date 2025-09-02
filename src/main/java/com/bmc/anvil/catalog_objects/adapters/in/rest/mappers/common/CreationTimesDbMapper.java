package com.bmc.anvil.catalog_objects.adapters.in.rest.mappers.common;

import org.mapstruct.Mapper;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
@Mapper(componentModel = "jakarta", uses = {IdMapper.class})
public interface CreationTimesDbMapper {

    //    CreationTimes fromDynamo(CreationTimesDynamo creationTimesDynamo);

}
