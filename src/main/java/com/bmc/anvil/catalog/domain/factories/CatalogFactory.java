package com.bmc.anvil.catalog.domain.factories;

import com.bmc.anvil.catalog.domain.models.entities.Catalog;

import io.smallrye.mutiny.Uni;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
public class CatalogFactory {

    public <T extends Catalog> Uni<T> createFromDto(String catalogType, Object dto) {

        return null;
    }

}
