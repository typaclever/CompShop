package dao.daoImpl.randomAcessMemory.memoryType;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.randomAcessMemory.ramBrand.MemoryTypeCrudOperations;
import entity.graphics.GraphicsBrand;
import entity.randomAccessMemory.MemoryType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class MemoryTypeDaoImpl implements MemoryTypeCrudOperations {

    private static MemoryTypeDaoImpl memoryTypeDao;

    private MemoryTypeDaoImpl(){

    }

    public static MemoryTypeDaoImpl getInstance(){
        return memoryTypeDao != null ? memoryTypeDao : (memoryTypeDao = new MemoryTypeDaoImpl());
    }

    @Override
    public MemoryType getMemoryTypeById(Long id) {
        return SessionFactoryAccess.getSessionFactory().openSession().get(MemoryType.class, id);
    }

    @Override
    public void deleteMemoryType(Long id) {
        MemoryType memoryType = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((memoryType = getMemoryTypeById(id)) != null) {
            session.beginTransaction();
            session.delete(memoryType);
            session.getTransaction().commit();
        } else {

        }
        session.close();
    }

    @Override
    public void saveMemoryType(MemoryType memoryType) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(memoryType);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<MemoryType> getAllMemoryTypes() {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MemoryType> query = builder.createQuery(MemoryType.class);
        Root<MemoryType> root = query.from(MemoryType.class);
        return session.createQuery(query.select(root)).list();
    }

    @Override
    public void updateMemoryType(MemoryType memoryType) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(memoryType);
        session.getTransaction().commit();
        session.close();
    }
}
