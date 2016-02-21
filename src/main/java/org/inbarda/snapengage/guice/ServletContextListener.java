package org.inbarda.snapengage.guice;

import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

/**
 * Created by Inbar on 18/02/2016.
 */
public class ServletContextListener extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return InjectorFactory.create();
    }


}
