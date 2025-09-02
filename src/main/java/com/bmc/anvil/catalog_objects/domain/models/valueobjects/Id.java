package com.bmc.anvil.catalog_objects.domain.models.valueobjects;

import java.util.UUID;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import static java.util.UUID.fromString;
import static java.util.UUID.randomUUID;

/**
 * Value object that represents the unique identifier (Id) for entities in the domain.
 * <br>This class uses {@link UUID} as the underlying unique identifier and is immutable.
 *
 * @author BareMetalCode
 */
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public final class Id {

    @EqualsAndHashCode.Include
    private final UUID id;

    private Id(final UUID id) {

        this.id = id;
    }

    /**
     * Creates a new instance with a randomly generated UUID.
     *
     * @return A new {@link Id} instance with a unique identifier.
     */
    public static Id create() {

        return new Id(randomUUID());
    }

    /**
     * Creates a new {@link Id} instance from the specified {@link UUID}.
     *
     * @param value the UUID to convert into an {@link Id} instance; must not be null.
     *
     * @return a new {@link Id} instance containing the specified UUID.
     */
    public static Id from(@NonNull final UUID value) {

        return new Id(value);
    }

    /**
     * Creates an instance of {@link Id} from a String representation of a UUID.
     * This is particularly useful for deserialization or integrating with external systems.
     *
     * @param value The UUID string representation (must not be null or empty).
     *
     * @return A new {@link Id} instance.
     *
     * @throws IllegalArgumentException If the given value cannot be parsed into a UUID.
     */
    public static Id from(@NonNull final String value) throws IllegalArgumentException {

        try {
            return new Id(fromString(value));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid UUID string: " + value, e);
        }
    }

    /**
     * Returns the string representation of the unique identifier).
     *
     * @return the unique identifier as a string.
     */
    public String getIdAsString() {

        return id.toString();
    }

}
