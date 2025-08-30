package com.bmc.anvil.catalog.adapters.out.databases.dynamodb;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

import com.bmc.anvil.catalog.application.ports.out.CatalogOutputPort;
import com.bmc.anvil.catalog.domain.models.CatalogType;
import com.bmc.anvil.catalog.domain.models.entities.Catalog;
import com.bmc.anvil.catalog.infrastructure.logging.Logged;

import io.smallrye.mutiny.Uni;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
@Logged
@ApplicationScoped
public class CatalogDynamoAdapter implements CatalogOutputPort {

    @Override
    public Uni<Catalog> delete(final Catalog catalog) {

        return null;
    }

    @Override
    public Uni<List<Catalog>> getAllByType(final CatalogType catalogType) {

        final List<Catalog> randomList = List.of(new Catalog(), new Catalog(), new Catalog());
        return Uni.createFrom().item(randomList);
    }

    @Override
    public Uni<Catalog> getOne(final Catalog catalog) {

        return null;
    }

    @Override
    public Uni<Catalog> save(final Catalog catalog) {

        return Uni.createFrom().item(catalog);
    }

    @Override
    public Uni<Catalog> update(final Catalog catalog) {

        return null;
    }

}
