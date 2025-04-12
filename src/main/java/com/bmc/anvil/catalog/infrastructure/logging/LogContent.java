package com.bmc.anvil.catalog.infrastructure.logging;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
@Getter
@Builder
@ToString
public class LogContent {

    @ToString.Exclude
    @JsonIgnore
    private String   classFullName;
    private String   classSimpleName;
    private String   methodCalled;
    private Object[] methodParameters;

}
