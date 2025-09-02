package com.bmc.anvil.catalog_objects.infrastructure.logging;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.interceptor.InvocationContext;

import static com.bmc.anvil.catalog_objects.infrastructure.logging.utils.LogUtils.*;

/**
 * FIXME: add documentation: focus on "description", "why", "how", "caveats"[...] more that simple descriptions, as those should be
 *        inferred from code and names as much as possible.
 *
 * @author BareMetalCode
 */
@ApplicationScoped
public class LogContentFactory {

    public LogContent fromContext(final InvocationContext context) {

        return LogContent.builder()
                         .classFullName(extractFullClassName.apply(context))
                         .classSimpleName(extractSimpleClassName(context))
                         .methodCalled(extractMethodName(context))
                         .methodParameters(context.getParameters())
                         .build();
    }

}
