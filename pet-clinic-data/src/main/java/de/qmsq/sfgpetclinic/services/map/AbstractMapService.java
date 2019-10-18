package de.qmsq.sfgpetclinic.services.map;

import de.qmsq.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    private Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {

        if (object != null) {
            if(object.getId() == null) {
                object.setId(getNext());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("objects cannnot be null");
        }
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNext() {
        Long nextId = null;

        try {
            nextId = Collections.max(map.keySet()) +1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }

}
