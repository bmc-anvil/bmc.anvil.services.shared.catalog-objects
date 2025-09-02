package com.bmc.anvil.catalog_objects.infrastructure.logging.utils;

import java.util.function.Function;

import jakarta.interceptor.InvocationContext;

import com.bmc.anvil.catalog_objects.infrastructure.logging.LogLevel;
import com.bmc.anvil.catalog_objects.infrastructure.logging.Logged;
import com.bmc.anvil.catalog_objects.infrastructure.logging.LoggingFunction;

import static com.bmc.anvil.catalog_objects.infrastructure.logging.LogLevel.INFO;
import static java.util.Optional.ofNullable;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
@Logged(exclude = true)
public class LogUtils {

    private static final Function<InvocationContext, String> extractFullClassName0 = context -> context.getMethod().getDeclaringClass().getName();
    public static        Function<InvocationContext, String> extractFullClassName  = LoggingFunction.logFunction(extractFullClassName0);

    public static String extractFullClassNamef(final InvocationContext context) {

        return context.getMethod().getDeclaringClass().getName();
    }

    public static String extractMethodName(final InvocationContext context) {

        return context.getMethod().getName();
    }

    public static String extractSimpleClassName(final InvocationContext context) {

        return context.getMethod().getDeclaringClass().getSimpleName();
    }

    /**
     * Retrieves the log level defined in the {@link Logged} annotation for the given invocation context.
     * <p>
     * The method first checks for the annotation at the method level. If not found, it then checks at the class level.
     * <p>
     * If the annotation is absent in both places, the default log level {@link LogLevel#INFO} is returned.
     *
     * @param context the context of the method or class being invoked, used to retrieve annotations.
     *
     * @return the {@link LogLevel} defined in the {@link Logged} annotation; defaults to {@link LogLevel#INFO} if absent.
     */
    public static LogLevel getLogLevelFromAnnotation(final InvocationContext context) {

        return ofNullable(context.getMethod().getAnnotation(Logged.class))
                .or(() -> ofNullable(context.getMethod().getDeclaringClass().getAnnotation(Logged.class)))
                .map(Logged::value)
                .orElse(INFO);
    }

    /**
     * Truncates each package element to a maximum of three characters.
     *
     * @param fullClassName Fully qualified class name, e.g., com.bmc.anvil.catalog.adapter.in.rest.CatalogController
     *
     * @return Abbreviated class name, e.g., com.bmc.anv.cat.ada.in.res.CatalogController for a 3 maximum length slugh size
     */
    public static String maxPathPartLength(final String fullClassName, final int maxPartSize) {

        final StringBuilder truncatedPathAndClassName = new StringBuilder();
        final String[]      parts                     = fullClassName.split("\\.");
        final int           partsLength               = parts.length;
        final String        className                 = parts[partsLength - 1];

        for (int i = 0; i < partsLength - 1; i++) {
            final String part = parts[i];
            truncatedPathAndClassName.append(part.length() > maxPartSize ? part.substring(0, maxPartSize) : part)
                                     .append(".");
        }

        return truncatedPathAndClassName.append(className).toString();
    }

}
