package com.bmc.anvil.catalog_objects.adapters.shared.config.serializer;

import java.util.List;

import com.bmc.anvil.catalog_objects.domain.models.entities.Catalog;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;

import static com.bmc.anvil.catalog_objects.adapters.shared.config.serializer.SerializerUtils.isAssignableFromBean;
import static com.bmc.anvil.catalog_objects.adapters.shared.config.serializer.SerializerUtils.removeItemsFromWriters;
import static java.util.List.of;

public class ExcludeFieldsSerializerModifier extends BeanSerializerModifier {

    private static final String       ID_AS_STRING          = "idAsString";
    private static final String       ID_VALUE              = "idValue";
    private final        List<String> catalogFieldsToRemove = of(ID_AS_STRING, ID_VALUE);

    @Override
    public List<BeanPropertyWriter> changeProperties(final SerializationConfig config, final BeanDescription beanDescription,
            final List<BeanPropertyWriter> beanProperties) {

        if (doNotRequireAnyUpdate(beanDescription)) {
            return beanProperties;
        }

        return filteredProperties(beanProperties);
    }

    private boolean doNotRequireAnyUpdate(final BeanDescription beanDescription) {

        return isAssignableFromBean(Catalog.class, beanDescription);
    }

    private List<BeanPropertyWriter> filteredProperties(final List<BeanPropertyWriter> beanProperties) {

        return removeItemsFromWriters(catalogFieldsToRemove, beanProperties);
    }

}
