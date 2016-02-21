package org.inbarda.snapengage.guice.Modules;

import com.google.inject.servlet.ServletModule;
import org.inbarda.snapengage.api.ChatsServlet;
import org.inbarda.snapengage.api.WebhookServlet;

/**
 * Created by Inbar on 18/02/2016.
 */
public class WebModule extends ServletModule {

    @Override
    protected void configureServlets() {

        serve("/api/webhook").with(WebhookServlet.class);
        serve("/api/chats").with(ChatsServlet.class);
    }
}
