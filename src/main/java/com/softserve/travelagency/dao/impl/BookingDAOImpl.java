package com.softserve.travelagency.dao.impl;

import com.softserve.travelagency.dao.BookingDAO;
import com.softserve.travelagency.model.Booking;
import com.softserve.travelagency.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

@Repository
public class BookingDAOImpl implements BookingDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Booking> getBookings() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery< Booking > cq = cb.createQuery(Booking.class);
        Root< Booking > root = cq.from(Booking.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        List result = query.getResultList();
        session.getTransaction().commit();
        return result;
    }

    @Override
    public void saveBooking(Booking booking) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        currentSession.save(booking);
        currentSession.getTransaction().commit();
        currentSession.close();
    }

    @Override
    public Booking getBooking(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Booking.class, id);
    }

    @Override
    public void deleteBooking(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Booking booking = session.byId(Booking.class).load(id);
        session.delete(booking);
    }

    @Override
    public List<Booking> getBookingByDate(LocalDate enter, LocalDate departure, String countryName, String roomType, String stars, boolean cleaning) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("from Booking b\n" +
//                "                  inner join Room r on b.room.id = r.id\n" +
//                "                  inner join Hotel h on r.hotel.id = h.id\n" +
//                "                  inner join Country c on h.country.id = c.id\n" +
                "where ((b.dateOfEntrance between :enter and :departure)\n" +
                "    and (b.dateOfDeparture between :enter and :departure)\n" +
                "or (:enter between b.dateOfEntrance and b.dateOfDeparture)\n" +
                "    and (:departure between b.dateOfEntrance and b.dateOfDeparture)\n" +
                "or (b.dateOfEntrance between :enter and :departure)\n" +
                "    and (b.dateOfDeparture not between :enter and :departure)\n" +
                "or (b.dateOfEntrance not between :enter and :departure)\n" +
                "    and (b.dateOfDeparture between :enter and :departure))\n" +
                "and b.room.hotel.country.countryName = :countryName\n" +
                "and b.room.roomsType = :roomType\n" +
                "and b.room.hotel.stars = :stars\n" +
                "and b.room.cateringService = :cleaning");
        query.setParameter("enter", enter);
        query.setParameter("departure", departure);
        query.setParameter("countryName", countryName);
        query.setParameter("roomType", roomType);
        query.setParameter("stars", stars);
        query.setParameter("cleaning", cleaning);

        List<Booking> result = query.getResultList();
        session.getTransaction().commit();
        return result;
    }

}
