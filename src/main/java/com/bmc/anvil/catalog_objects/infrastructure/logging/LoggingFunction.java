package com.bmc.anvil.catalog_objects.infrastructure.logging;

import java.util.function.Function;

import io.quarkus.logging.Log;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
public class LoggingFunction<T, R> implements Function<T, R> {

    private final Function<T, R> wrappedFunction;

    public LoggingFunction(final Function<T, R> wrappedFunction) {

        this.wrappedFunction = wrappedFunction;
    }

    public static <T, R> Function<T, R> logFunction(final Function<T, R> function) {

        return new LoggingFunction<>(function);
    }

    @Override
    public R apply(final T t) {

        Log.debug("Calling Function.apply() with input: " + t);
        R result = wrappedFunction.apply(t);
        Log.debug("Function.apply() returned: " + result);
        return result;

    }

}
