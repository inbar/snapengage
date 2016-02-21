package org.inbarda.snapengage.services;

import org.inbarda.snapengage.persistence.dao.ChatDao;
import org.inbarda.snapengage.persistence.model.Chat;

import javax.inject.Inject;
import java.util.List;

public class ChatPersistenceService {

    private final ChatDao chatDao;

    @Inject
    public ChatPersistenceService(ChatDao chatDao) {
        this.chatDao = chatDao;
    }

    public void saveChat(Chat chat) {
        this.chatDao.save(chat);
    }

    public Chat read(int id) {
        return this.chatDao.read(id);
    }

    public List<Chat> readAll() {
        return this.chatDao.readAll();
    }

    public List<Chat> readAll(List<Integer> ids) {
        return this.chatDao.readAll(ids);
    }

    public List<Integer> getIds() {
        return this.chatDao.getIds();
    }

    /**
     * Reads the last (most recent) n chats.
     * If the total number of chats is smaller than n, returns all available chats.
     * The result is not sorted.
     *
     * @param n
     * @return A list with at most n most recent chats
     */
    public List<Chat> readLastN(int n) {
        List<Integer> ids = this.chatDao.getLastNIds(n);
        return this.readAll(ids);
    }
}
