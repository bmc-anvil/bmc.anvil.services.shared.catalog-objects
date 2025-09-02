package com.bmc.anvil.catalog_objects.adapters.shared.config.serializer;

import java.util.List;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
public class SerializerUtils {

    private SerializerUtils() {}

    public static boolean isAssignableFromBean(final Class<?> aClass, final BeanDescription beanDescription) {

        return aClass.isAssignableFrom(beanDescription.getBeanClass());
    }

    public static List<BeanPropertyWriter> removeItemsFromWriters(final List<String> itemsToRemove, final List<BeanPropertyWriter> writers) {

        for (String valueToRemove : itemsToRemove) {
            writers.removeIf(writer -> writer.getName().equals(valueToRemove));
        }
        return writers;
    }

}
