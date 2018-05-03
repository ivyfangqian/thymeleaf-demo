package com.fqivy.thymeleaf.example.demo.repository;

import com.fqivy.thymeleaf.example.demo.domain.User;

import java.util.List;

public interface UserRepository {
    public User saveOrUpdateUser(User user);

    public void deleteUser(Integer id);

    public User getUserById(Integer id);

    public List<User> listUser();
}
