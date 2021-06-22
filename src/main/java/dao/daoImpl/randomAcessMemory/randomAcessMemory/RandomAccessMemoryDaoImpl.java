package dao.daoImpl.randomAcessMemory.randomAcessMemory;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.randomAcessMemory.randomAcessMemory.RandomAccessMemoryCrudOperations;
import entity.graphics.GraphicsBrand;
import entity.randomAccessMemory.mainEntity.RandomAccessMemory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class RandomAccessMemoryDaoImpl implements RandomAccessMemoryCrudOperations {

    private static RandomAccessMemoryDaoImpl randomAccessMemoryDao;

    private RandomAccessMemoryDaoImpl(){

    }

    public static RandomAccessMemoryDaoImpl getInstance(){
        return randomAccessMemoryDao != null ? randomAccessMemoryDao
                : (randomAccessMemoryDao = new RandomAccessMemoryDaoImpl());
    }

    @Override
    public RandomAccessMemory getRandomAccessMemoryById(Long id) {
        return SessionFactoryAccess.getSessionFactory().openSession().get(RandomAccessMemory.class, id);
    }

    @Override
    public void deleteRandomAccessMemory(Long id) {
        RandomAccessMemory randomAccessMemory = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((randomAccessMemory = getRandomAccessMemoryById(id)) != null) {
            session.beginTransaction();
            session.delete(randomAccessMemory);
            session.getTransaction().commit();
        } else {

        }
        session.close();
    }

    @Override
    public void saveRandomAccessMemory(RandomAccessMemory ram) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(ram);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<RandomAccessMemory> getAllRandomAccessMemories() {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<RandomAccessMemory> query = builder.createQuery(RandomAccessMemory.class);
        Root<RandomAccessMemory> root = query.from(RandomAccessMemory.class);
        return session.createQuery(query.select(root)).list();
    }

    @Override
    public void updateRandomAccessMemory(RandomAccessMemory ram) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(ram);
        session.getTransaction().commit();
        session.close();
    }
}
