package com.bmc.anvil.catalog.domain.models.valueobjects;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static java.time.LocalDateTime.now;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
@Setter
@Getter
@ToString
public class CreationTimes {

    private LocalDateTime createdOn;
    private LocalDateTime lastUpdatedOn;

    public void init() {

        LocalDateTime now = now();
        createdOn     = now;
        lastUpdatedOn = now;
    }

}
