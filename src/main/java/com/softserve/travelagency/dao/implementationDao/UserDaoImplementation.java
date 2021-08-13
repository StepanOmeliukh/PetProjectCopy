package com.softserve.travelagency.dao.implementationDao;

import com.softserve.travelagency.dao.UserDao;
import com.softserve.travelagency.model.User;
import lombok.AllArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class UserDaoImplementation implements UserDao {

    @Autowired
    private final SessionFactory sessionFactory;

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);

        transaction.commit();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            User user = session.get(User.class, id);
            return Optional.of(user);
        } catch (NullPointerException npe) {
            return Optional.empty();
        } finally {
            transaction.commit();
        }
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("FROM User u WHERE u.email = :email", User.class);
            query.setParameter("email", email);
            User user = (User) query.uniqueResult();
            return Optional.of(user);
        } catch (NullPointerException exception) {
            return Optional.empty();
        } finally {
            transaction.commit();

        }
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            @SuppressWarnings("uncheked")
                    Query query = session.createQuery("FROM User ", User.class);
            return (List<User>) query.getResultList();
        } catch (NullPointerException exception) {
            return new ArrayList<>();
        } finally {
            transaction.commit();
        }
    }

    @Override
    public void deleteUser(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query<User> query = session.createQuery("DELETE FROM User " +
                "WHERE id =:userId");
        query.setParameter("userId", id);

        query.executeUpdate();
        transaction.commit();
    }
}
//

