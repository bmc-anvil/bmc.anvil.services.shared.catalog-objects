package com.bmc.anvil.catalog.infrastructure.config.serializer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Singleton;

import com.bmc.anvil.catalog.domain.models.valueobjects.Id;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
@Singleton
public class JacksonMapperProducer {

    @ApplicationScoped
    public ObjectMapper objectMapper() {

        final ObjectMapper objectMapper = new ObjectMapper();
        final SimpleModule module       = new SimpleModule();

        module.addSerializer(Id.class, new IdJsonSerializer());

        module.setSerializerModifier(new ExcludeFieldsSerializerModifier());

        objectMapper.registerModule(module);

        return objectMapper;
    }

}
