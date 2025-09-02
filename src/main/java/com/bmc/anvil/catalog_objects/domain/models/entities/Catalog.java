package com.bmc.anvil.catalog_objects.domain.models.entities;

import java.util.Map;

import com.bmc.anvil.catalog_objects.domain.models.CatalogType;
import com.bmc.anvil.catalog_objects.domain.models.valueobjects.CreationTimes;
import com.bmc.anvil.catalog_objects.domain.models.valueobjects.Id;
import com.bmc.anvil.catalog_objects.domain.models.valueobjects.Ownership;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import static lombok.AccessLevel.NONE;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 * <p>
 * Id
 *
 * @author BareMetalCode
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Catalog {

    @Setter(NONE)
    @EqualsAndHashCode.Include
    private final Id                  id;
    private       CatalogType         catalogType;
    private       CreationTimes       creationTimes;
    private       String              description;
    private       Boolean             isSystem = false;
    private       String              name;
    private       Ownership           ownership;
    private       Map<String, String> properties;

    public Catalog(final Id id) {

        this.id = id;
    }

    public Catalog() {

        this(Id.create());
    }

}
