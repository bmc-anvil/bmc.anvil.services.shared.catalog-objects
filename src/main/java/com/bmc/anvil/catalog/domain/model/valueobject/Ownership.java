package com.bmc.anvil.catalog.domain.model.valueobject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
@Data
public class Ownership {

    private Id accountId;
    private Id createdByUser;
    private Id lastUpdatedByUser;
    private Id projectId;

}
