package org.inbarda.snapengage.api;

import com.google.gson.Gson;
import org.inbarda.snapengage.persistence.dao.ChatDao;
import org.inbarda.snapengage.persistence.model.Chat;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Inbar on 18/02/2016.
 */

@Singleton
public class WebhookServlet extends HttpServlet {

    Logger log = Logger.getLogger(WebhookServlet.class.getName());

    private final Gson gson;
    private final ChatDao chatDao;


    @Inject
    public WebhookServlet(Gson gson, ChatDao chatDao) {
        this.gson = gson;
        this.chatDao = chatDao;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Chat chat = gson.fromJson(req.getReader(), Chat.class);
        chatDao.save(chat);
    }

}
