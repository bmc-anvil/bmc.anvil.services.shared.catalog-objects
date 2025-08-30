package com.bmc.anvil.catalog.adapters.in.rest.dtos.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
@Getter
@Setter
@ToString
public class OwnershipDTO {

    private String accountId;
    private String createdByUser;
    private String lastUpdatedByUser;
    private String projectId;

}
