package com.bmc.anvil.catalog_objects.application.ports.out;

import java.util.List;

import com.bmc.anvil.catalog_objects.domain.models.CatalogType;
import com.bmc.anvil.catalog_objects.domain.models.entities.Catalog;

import io.smallrye.mutiny.Uni;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
public interface CatalogOutputPort {

    Uni<Catalog> delete(Catalog catalog);

    Uni<List<Catalog>> getAllByType(CatalogType catalogType);

    Uni<Catalog> getOne(Catalog catalog);

    Uni<Catalog> save(Catalog catalog);

    Uni<Catalog> update(Catalog catalog);

}
