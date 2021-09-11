package ru.sergeyrozhkov.crud.service;

import ru.sergeyrozhkov.crud.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
}
