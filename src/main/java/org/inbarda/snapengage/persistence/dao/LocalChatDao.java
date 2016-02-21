package org.inbarda.snapengage.persistence.dao;

import org.inbarda.snapengage.persistence.model.Chat;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Singleton
public class LocalChatDao implements ChatDao {

    private HashMap<Integer, Chat> db;
    private AtomicInteger atomicInteger;


    public LocalChatDao() {
        this.db = new HashMap<>();
        this.atomicInteger = new AtomicInteger();
    }

    @Override
    public void save(Chat chat) {
        int id = nextId();
        chat.setInternalId(id);
        this.db.put(id, chat);
    }

    @Override
    public Chat read(int id) {
        if (!db.containsKey(id)) {
            throw new RuntimeException("Chat with ID: '" + id + "' does not exist");
        }

        return db.get(id);
    }

    @Override
    public List<Chat> readAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public List<Chat> readAll(List<Integer> ids) {
        List<Chat> result = new ArrayList<>();
        for (int id : ids) {
            if (db.containsKey(id)) {
                result.add(db.get(id));
            }
        }

        return result;
    }

    @Override
    public List<Integer> getIds() {
        return new ArrayList<>(db.keySet());
    }

    @Override
    public List<Integer> getLastNIds(int n) {
        ArrayList<Integer> result = new ArrayList<>(db.keySet());

        if (result.size() <= n) {
            return result;
        }
        Collections.sort(result, Collections.reverseOrder());
        return result.subList(0, n);
    }

    private int nextId() {
        return this.atomicInteger.getAndAdd(1);
    }
}
