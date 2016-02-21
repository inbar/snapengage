package org.inbarda.snapengage.persistence.dao;

import org.inbarda.snapengage.persistence.model.Chat;

import java.util.List;

public interface ChatDao {
    void save(Chat chat);
    Chat read(int id);
    List<Chat> readAll();
    List<Chat> readAll(List<Integer> ids);
    List<Integer> getIds();
    List<Integer> getLastNIds(int n);

}
