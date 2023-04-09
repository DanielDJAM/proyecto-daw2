package com.danieldjam.ecomer.dao;

import com.danieldjam.ecomer.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUserList() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }
}
