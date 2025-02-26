package com.bmc.anvil.catalog.application.ports.in;

import com.bmc.anvil.catalog.application.dto.request.CatalogCreateDTO;
import com.bmc.anvil.catalog.application.dto.response.CatalogResponseDTO;

import io.smallrye.mutiny.Uni;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
public interface CreateCatalogRESTInputPort {

    Uni<CatalogResponseDTO> execute(CatalogCreateDTO catalog);

}
