package ru.sergeyrozhkov.crud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.sergeyrozhkov.crud.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    EntityManagerFactory factory;

    @Autowired
    public void setFactory(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> getAllUsers() {
        EntityManager manager = factory.createEntityManager();
        TypedQuery<User> query = manager.createQuery("from User", User.class);
        return query.getResultList();
    }
}
