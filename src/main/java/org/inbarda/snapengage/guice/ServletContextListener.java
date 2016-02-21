package org.inbarda.snapengage.guice;

import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * A Servlet Context Listener which bootsraps Guice.
 * This listener itself is bootstraped in web.xml
 */
public class ServletContextListener extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return InjectorFactory.create();
    }


}
