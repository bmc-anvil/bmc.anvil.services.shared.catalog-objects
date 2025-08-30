package com.bmc.anvil.catalog.adapters.in.rest.mappers.common;

import java.util.UUID;

import com.bmc.anvil.catalog.domain.models.valueobjects.Id;

import org.mapstruct.Mapper;

import lombok.NonNull;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
@Mapper(componentModel = "jakarta")
public interface IdMapper {

    default Id fromString(final String id) {

        return Id.from(id);
    }

    default Id fromUUID(final UUID id) {

        return Id.from(id);
    }

    default String toString(@NonNull final Id id) {

        return id.getIdAsString();
    }

    default UUID toUUID(@NonNull final Id id) {

        return id.getId();
    }

}
