package com.fqivy.thymeleaf.example.demo.repository;

import com.fqivy.thymeleaf.example.demo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static AtomicInteger counter = new AtomicInteger();
    private final ConcurrentMap<Integer, User> userMap = new ConcurrentHashMap<>();

    @Override
    public User saveOrUpdateUser(User user) {
        Integer id = user.getId();
        if (id == null) {
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.userMap.put(id, user);
        return user;
    }

    @Override
    public void deleteUser(Integer id) {
        this.userMap.remove(id);
    }

    @Override
    public User getUserById(Integer id) {
        return this.userMap.get(id);
    }

    @Override
    public List<User> listUser() {
        return new ArrayList<User>(this.userMap.values());
    }
}
