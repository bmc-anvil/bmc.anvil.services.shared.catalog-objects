package com.bmc.anvil.catalog.infrastructure.logging;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.interceptor.InterceptorBinding;

import static com.bmc.anvil.catalog.infrastructure.logging.LogLevel.INFO;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The {@code @Logged} annotation is used to enable logging behavior for the annotated class or method.<br>
 * <p>
 * Applying this annotation on a class results in logging for all methods within the class or extending classes.<br>
 * At the method level, it logs only the annotated method's execution and overrides a class level annotation configuration if any.
 * <p>
 * {@code @Target}: Can be applied to types (classes, interfaces) or individual methods.<br>
 * {@code @Retention}: Runtime retention ensures the annotation is accessible for processing at runtime.<br>
 * {@code @Inherited}: Allows inheriting the annotation for subclasses.
 *
 * @see LoggingInterceptor
 */
@InterceptorBinding
@Retention(RUNTIME)
@Target({TYPE, METHOD})
@Inherited
public @interface Logged {

    /**
     * Specifies whether the annotated method or class should be excluded from logging.
     * When set to {@code true}, the method or class won't be logged by the global {@link LoggingInterceptor}
     *
     * @return a boolean value indicating whether logging should be excluded for the annotated element.
     */
    boolean exclude() default false;

    /**
     * Log level to be used when logging method calls.
     * Defaults to INFO.
     */
    LogLevel value() default INFO;

}
