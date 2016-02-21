package org.inbarda.snapengage.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.inbarda.snapengage.guice.Modules.MainModule;
import org.inbarda.snapengage.guice.Modules.WebModule;

public class InjectorFactory {

    public static Injector create() {
        return Guice.createInjector(
                new MainModule(),
                new WebModule()
        );
    }
}
