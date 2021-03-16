package kotlarchik.service;

import kotlarchik.dao.DAO;
import kotlarchik.model.EntityAbonent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceAbonent implements DAO<EntityAbonent, Integer> {
    private SessionFactory factory;

    private ServiceAbonent(SessionFactory factory){
        this.factory = factory;
    }

    public void create(EntityAbonent entityAbonent) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(entityAbonent);
            session.getTransaction().commit();
        }
    }

    public EntityAbonent read(Integer id) {
        try (Session session = factory.openSession()){
            EntityAbonent entityAbonent = session.get(EntityAbonent.class, id);
            return entityAbonent;
        }
    }

    public List<EntityAbonent> readAll() {
        try (Session session = factory.openSession()){
            Query<EntityAbonent> query = session.createQuery("FROM EntityAbonent");
            return query.list();
        }
    }

    public void update(EntityAbonent entityAbonent) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(entityAbonent);
            session.getTransaction().commit();
        }
    }

    public void delete(EntityAbonent entityAbonent) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(entityAbonent);
            session.getTransaction().commit();
        }
    }
}
