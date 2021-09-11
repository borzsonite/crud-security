package ru.sergeyrozhkov.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sergeyrozhkov.crud.dao.UserDao;
import ru.sergeyrozhkov.crud.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService{
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
