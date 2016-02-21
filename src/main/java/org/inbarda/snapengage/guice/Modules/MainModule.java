package org.inbarda.snapengage.guice.Modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.inbarda.snapengage.persistence.dao.ChatDao;
import org.inbarda.snapengage.persistence.dao.LocalChatDao;

public class MainModule extends AbstractModule{

    @Override
    protected void configure() {

        bind(ChatDao.class).to(LocalChatDao.class);

    }

    @Provides
    Gson provideGson() {
        Gson gson = new GsonBuilder().create();
        return gson;
    }

}
