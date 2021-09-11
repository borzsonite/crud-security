package ru.sergeyrozhkov.crud.dao;

import ru.sergeyrozhkov.crud.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
}
