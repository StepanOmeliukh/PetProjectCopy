package com.softserve.travelagency.dao.Hotel;

import com.softserve.travelagency.model.Country;
import com.softserve.travelagency.model.Hotel;
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
}
