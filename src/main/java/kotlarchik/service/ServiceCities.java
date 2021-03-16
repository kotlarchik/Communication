package kotlarchik.service;

import kotlarchik.dao.DAO;
import kotlarchik.model.EntityCities;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceCities implements DAO<EntityCities, Integer> {
    private SessionFactory factory;

    public ServiceCities(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public void create(EntityCities entityCities) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(entityCities);
            session.getTransaction().commit();
        }
    }

    @Override
    public EntityCities read(Integer id) {
        try (Session session = factory.openSession()){
            EntityCities entityCities = session.get(EntityCities.class, id);
            return entityCities;
        }
    }

    @Override
    public List<EntityCities> readAll() {
        try (Session session = factory.openSession()){
            Query<EntityCities> query = session.createQuery("FROM EntityCities");
            return query.list();
        }
    }

    @Override
    public void update(EntityCities entityCities) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(entityCities);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(EntityCities entityCities) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(entityCities);
            session.getTransaction().commit();
        }
    }
}
