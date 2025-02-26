package com.bmc.anvil.catalog.infrastructure.config.serializer;

import java.io.IOException;

import com.bmc.anvil.catalog.domain.model.valueobject.Id;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
public class IdJsonSerializer extends JsonSerializer<Id> {

    @Override
    public void serialize(final Id value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException {
        gen.writeString(value.getIdAsString());
    }

}
