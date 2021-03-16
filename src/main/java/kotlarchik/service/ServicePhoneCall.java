package kotlarchik.service;

import kotlarchik.dao.DAO;
import kotlarchik.model.EntityPhoneCall;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ServicePhoneCall implements DAO<EntityPhoneCall, Integer> {
    private SessionFactory factory;

    private ServicePhoneCall(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(EntityPhoneCall entityPhoneCall) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(entityPhoneCall);
            session.getTransaction().commit();
        }
    }

    @Override
    public EntityPhoneCall read(Integer id) {
        try (Session session = factory.openSession()){
            EntityPhoneCall entityPhoneCall = session.get(EntityPhoneCall.class, id);
            return entityPhoneCall;
        }
    }

    @Override
    public List<EntityPhoneCall> readAll() {
        try (Session session = factory.openSession()){
            Query<EntityPhoneCall> query = session.createQuery("FROM EntityPhoneCall");
            return query.list();
        }
    }

    @Override
    public void update(EntityPhoneCall entityPhoneCall) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(entityPhoneCall);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(EntityPhoneCall entityPhoneCall) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(entityPhoneCall);
            session.getTransaction().commit();
        }
    }
}
