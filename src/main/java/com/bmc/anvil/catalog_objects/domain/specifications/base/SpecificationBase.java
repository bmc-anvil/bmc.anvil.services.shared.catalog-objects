package com.bmc.anvil.catalog_objects.domain.specifications.base;

import java.util.function.Predicate;

/**
 * Abstract base class for implementing the Specification pattern using {@link Predicate}.
 * <p>
 * This class represents a reusable and composable rule that validates data of type {@code T}.
 * It provides default methods for combining specifications using "AND", "OR", and "NOT" logic.
 *
 * @param <T> The type of data that this specification evaluates.
 */
public abstract class SpecificationBase<T> {

    /**
     * Represents the validation rule for this specification as a {@link Predicate}.
     *
     * @return A predicate representing the specification rule.
     */
    protected abstract Predicate<T> getValidationRule();

    /**
     * Provides the default exception message used when a candidate does not satisfy the specification.
     *
     * @return The exception message indicating that the candidate failed the specification.
     */
    protected String getExceptionMessage(final T input) {

        {
            return "Candidate [%s] does not satisfy the specification.".formatted(input);
        }
    }

    /**
     * Combines this specification with another using "AND" logic.
     *
     * @param other The other specification to combine.
     *
     * @return A new specification representing the combination.
     */
    public SpecificationBase<T> and(SpecificationBase<T> other) {

        return new SpecificationBase<>() {
            @Override
            protected Predicate<T> getValidationRule() {

                return SpecificationBase.this.getValidationRule().and(other.getValidationRule());
            }
        };
    }

    /**
     * Checks if the specified input satisfies the validation rule.
     *
     * @param input The item to validate against the validation rule.
     *
     * @return {@code true} if the input satisfies the specification.
     *
     * @throws IllegalArgumentException if it fails
     */
    public boolean isSatisfiedBy(T input) throws IllegalArgumentException {

        if (!getValidationRule().test(input)) {
            throw new IllegalArgumentException(getExceptionMessage(input));
        }

        return true;
    }

    /**
     * Negates this specification using "NOT" logic.
     *
     * @return A new specification representing the negation of this specification.
     */
    public SpecificationBase<T> not() {

        return new SpecificationBase<>() {
            @Override
            protected Predicate<T> getValidationRule() {

                return SpecificationBase.this.getValidationRule().negate();
            }
        };
    }

    /**
     * Combines this specification with another using "OR" logic.
     *
     * @param other The other specification to combine.
     *
     * @return A new specification representing the combination.
     */
    public SpecificationBase<T> or(SpecificationBase<T> other) {

        return new SpecificationBase<>() {
            @Override
            protected Predicate<T> getValidationRule() {

                return SpecificationBase.this.getValidationRule().or(other.getValidationRule());
            }
        };
    }

}
