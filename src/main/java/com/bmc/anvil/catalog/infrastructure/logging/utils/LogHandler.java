package com.bmc.anvil.catalog.infrastructure.logging.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bmc.anvil.catalog.infrastructure.logging.LogContent;
import com.bmc.anvil.catalog.infrastructure.logging.LogLevel;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
public class LogHandler {

    public static final String METHOD_CALL = "methodCall";

    private final boolean jsonLoggingEnabled;

    public LogHandler(@ConfigProperty(name = "quarkus.log.console.json", defaultValue = "false") final boolean jsonLoggingEnabled) {
        this.jsonLoggingEnabled = jsonLoggingEnabled;
    }

    public void log(final Logger logger, final LogLevel logLevel, final LogContent logContent) {
        final Object       formattedMessage = format(logContent);
        final List<Object> parameters       = new ArrayList<>();

        if (jsonLoggingEnabled) {
            parameters.add(METHOD_CALL);
        }

        parameters.add(formattedMessage);

        final Object[] loggerParameters = parameters.toArray();

        switch (logLevel) {
            case DEBUG -> logger.debugf("%s", loggerParameters);
            case ERROR -> logger.errorf("%s", loggerParameters);
            case TRACE -> logger.tracef("%s", loggerParameters);
            case WARN -> logger.warnf("%s", loggerParameters);
            default -> logger.infof("%s", loggerParameters);
        }
    }

    private Object format(LogContent logContent) {
        return jsonLoggingEnabled ? Map.of(METHOD_CALL, logContent)
                                  : "method: [%s] parameter(s):(%s)".formatted(logContent.getMethodCalled(), logContent.getMethodParameters());
    }

}
