package com.softserve.travelagency.dao.impl;

import com.softserve.travelagency.dao.RoomDAO;
import com.softserve.travelagency.model.Country;
import com.softserve.travelagency.model.Hotel;
import com.softserve.travelagency.model.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

@Repository
public class RoomDAOImpl implements RoomDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Room> getRooms() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Room> cq = cb.createQuery(Room.class);
        Root< Room > root = cq.from(Room.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        List result = query.getResultList();
        session.getTransaction().commit();
        return result;
    }

    @Override
    public void saveRoom(Room room) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        currentSession.saveOrUpdate(room);
        currentSession.getTransaction().commit();
        currentSession.close();
    }

    @Override
    public Room getRoom(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.beginTransaction();
        Room result = currentSession.byId(Room.class).load(id);
        currentSession.getTransaction().commit();
        currentSession.close();
        return result;
    }

    @Override
    public void deleteRoom(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Room room = session.byId(Room.class).load(id);
        session.delete(room);
    }

    @Override
    public List<Room> getRoomsByParams(String countryName, String roomType, String stars, boolean cleaning) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("select r from Room r\n" +
                "    inner join Hotel h on r.hotel.id = h.id\n" +
                "    inner join Country c on h.country.id = c.id\n" +
                "where c.countryName = :countryName\n" +
                "  and r.roomsType = :roomsType\n" +
                "  and h.stars = :stars\n" +
                "  and r.cateringService = :cateringService");
        query.setParameter("countryName", countryName);
        query.setParameter("roomsType", roomType);
        query.setParameter("stars", stars);
        query.setParameter("cateringService", cleaning);

        Query query2 = session.createQuery("select h from Room r\n" +
                "    inner join Hotel h on r.hotel.id = h.id\n" +
                "    inner join Country c on h.country.id = c.id\n" +
                "where c.countryName = :countryName\n" +
                "  and r.roomsType = :roomsType\n" +
                "  and h.stars = :stars\n" +
                "  and r.cateringService = :cateringService");
        query2.setParameter("countryName", countryName);
        query2.setParameter("roomsType", roomType);
        query2.setParameter("stars", stars);
        query2.setParameter("cateringService", cleaning);

        List<Hotel> result2 = query2.getResultList();
        List<Room> result = query.getResultList();
        session.getTransaction().commit();

        for (int i = 0; i < result2.size(); i++) {
            result.get(i).setHotel(result2.get(i));
        }

        return result;
    }
}