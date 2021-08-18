package com.softserve.travelagency.dao.impl;

import com.softserve.travelagency.dao.RoomDAO;
import com.softserve.travelagency.model.Country;
import com.softserve.travelagency.model.Room;
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
        return currentSession.get(Room.class, id);
    }

    @Override
    public void deleteRoom(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Room room = session.byId(Room.class).load(id);
        session.delete(room);
    }
}
