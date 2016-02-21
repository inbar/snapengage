package org.inbarda.snapengage.api;

import com.google.common.primitives.Ints;
import com.google.gson.Gson;
import org.inbarda.snapengage.persistence.model.Chat;
import org.inbarda.snapengage.services.ChatPersistenceService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

@Singleton
public class ChatsServlet extends HttpServlet {

    private enum GetParams {
        N("n");

        private String value;

        GetParams(String value) {
            this.value = value;
        }
    }

    private final Gson gson;
    private final ChatPersistenceService chatService;

    @Inject
    public ChatsServlet(Gson gson, ChatPersistenceService chatService) {
        this.gson = gson;
        this.chatService = chatService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Chat> chats = null;
        Integer n = null;

        String param = req.getParameter(GetParams.N.value);
        if (param != null) {
            n = Ints.tryParse(param);
        }

        if (n != null) {
            chats = chatService.readLastN(n);
        } else {
            chats = chatService.readAll();
        }

        String json = gson.toJson(chats);
        PrintWriter respWriter = resp.getWriter();
        respWriter.println(json);
    }
}
