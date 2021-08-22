package com.softserve.travelagency.dao.impl;

import com.softserve.travelagency.dao.CountryDAO;
import com.softserve.travelagency.model.Country;
import com.softserve.travelagency.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
public class CountryDAOImpl implements CountryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Country> getCountries() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery< Country > cq = cb.createQuery(Country.class);
        Root< Country > root = cq.from(Country.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        List result = query.getResultList();
        session.getTransaction().commit();
        return result;
    }

    @Override
    public void saveCountry(Country country) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        currentSession.saveOrUpdate(country);
        currentSession.getTransaction().commit();
        currentSession.close();
    }

    @Override
    public Country getCountry(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Country.class, id);
    }

    @Override
    public void deleteCountry(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Country country = session.byId(Country.class).load(id);
        session.delete(country);
    }

    @Override
    public Country getCountryByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("FROM Country c WHERE c.countryName = :countryName", Country.class);
        query.setParameter("countryName", username);
        Country result = (Country) query.getSingleResult();
        session.getTransaction().commit();
        return result;
    }
}