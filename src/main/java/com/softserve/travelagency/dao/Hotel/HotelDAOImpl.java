package com.softserve.travelagency.dao.Hotel;

import com.softserve.travelagency.model.Country;
import com.softserve.travelagency.model.Hotel;
import com.softserve.travelagency.service.Country.CountryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class HotelDAOImpl implements HotelDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private CountryService countryService;

    @Override
    public List<Hotel> getHotels() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery< Hotel > cq = cb.createQuery(Hotel.class);
        Root< Hotel > root = cq.from(Hotel.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        List result = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return result;

    }

    @Override
    public void saveHotel(Hotel hotel) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        currentSession.saveOrUpdate(hotel);
        currentSession.getTransaction().commit();
        currentSession.close();
    }

    @Override
    public Hotel getHotel(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Hotel.class, id);
    }

    @Override
    public void deleteHotel(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Hotel hotel = session.byId(Hotel.class).load(id);
        session.delete(hotel);
    }

    @Override
    public List<Hotel> findHotelByCountryName(String countryName) {
        Country country = countryService.getCountryByUsername(countryName);
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("FROM Hotel h WHERE country.id = :country_id", Hotel.class);
        query.setParameter("country_id", country.getId());
        List<Hotel> resultList = query.getResultList();

        session.getTransaction().commit();
        session.close();
        return resultList;
    }

    @Override
    public Hotel getHotelByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("FROM Hotel h WHERE h.hotelName = :hotelName", Hotel.class);
        query.setParameter("hotelName", username);
        Hotel result = (Hotel) query.getSingleResult();
        session.getTransaction().commit();
        return result;
    }

}
