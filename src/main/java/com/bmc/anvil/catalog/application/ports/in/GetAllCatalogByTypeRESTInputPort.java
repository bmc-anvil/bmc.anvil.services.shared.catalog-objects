package com.bmc.anvil.catalog.application.ports.in;

import java.util.List;

import com.bmc.anvil.catalog.application.dto.response.CatalogResponseDTO;
import com.bmc.anvil.catalog.domain.model.CatalogType;

import io.smallrye.mutiny.Uni;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
public interface GetAllCatalogByTypeRESTInputPort {

    Uni<List<CatalogResponseDTO>> execute(CatalogType catalogType);

}
