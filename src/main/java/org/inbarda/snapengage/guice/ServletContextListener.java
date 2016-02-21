package org.inbarda.snapengage.guice;

import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class ServletContextListener extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return InjectorFactory.create();
    }


}
