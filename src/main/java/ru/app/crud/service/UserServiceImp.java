package ru.app.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.app.crud.dao.UserDao;
import ru.app.crud.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public void save(User newUser) {
        Long userId = newUser.getId();
        if (userId == null) {
            userDao.save(newUser);
            return;
        } else {
            User user = userDao.getUserById(userId);
            user.setName(newUser.getName());
            user.setDepartment(newUser.getDepartment());
            user.setSalary(newUser.getSalary());
            userDao.save(user);
        }
    }

    @Transactional
    @Override
    public void remove(User user) {
        userDao.remove(user);
    }

    @Transactional
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
}
