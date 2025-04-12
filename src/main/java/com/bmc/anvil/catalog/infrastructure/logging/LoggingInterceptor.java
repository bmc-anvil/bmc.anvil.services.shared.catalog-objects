package com.bmc.anvil.catalog.infrastructure.logging;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import io.quarkus.logging.Log;

import org.jboss.logging.Logger;

import static jakarta.interceptor.Interceptor.Priority.APPLICATION;
import static java.util.Objects.isNull;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
@Logged
@Priority(APPLICATION)
@Interceptor
public class LoggingInterceptor {

    private final LogContentFactory        logContentFactory = new LogContentFactory();
    private final Map<String, Logger>      loggerMap         = new ConcurrentHashMap<>();
    private final Function<String, Logger> getOrCreateLogger = loggerName -> loggerMap.computeIfAbsent(loggerName, Logger::getLogger);

    public LoggingInterceptor() {}

    @AroundInvoke
    public Object logMethodCall(final InvocationContext context) throws Exception {

        if (avoidInterceptionDetected(context)) {
            Log.warn("Self Interception detected: safely returning to the invocation chain");
            return proceedInvocation(context);
        }

        logMessage(context);
        return proceedInvocation(context);
    }

    private boolean avoidInterceptionDetected(final InvocationContext context) {

        final Predicate<String> isSelfInvocation = className -> className.contains(this.getClass().getPackageName());

        return isSelfInvocation.or(ignore -> isNull(context.getTarget())).test(context.getMethod().getDeclaringClass().getPackageName());
    }

    private void logMessage(final InvocationContext context) {

        final LogContent logContent = logContentFactory.fromContext(context);

        Log.infof("%s", Map.of("intercepted", logContent));

    }

    private Object proceedInvocation(final InvocationContext context) throws Exception {

        try {
            return context.proceed();
        } catch (Exception e) {
            getOrCreateLogger.apply(this.getClass().getName()).error("interceptor error", e);
            return null;
            //            return context.proceed();
        }
    }

}
