package dao.daoImpl.memory.memoryCellType;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.memory.memoryCellType.MemoryCellTypeCrudOperations;
import entity.graphics.GraphicsBrand;
import entity.memory.MemoryCellType;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MemoryCellTypeDaoImpl implements MemoryCellTypeCrudOperations {

    private static MemoryCellTypeDaoImpl memoryCellTypeDao;

    private MemoryCellTypeDaoImpl(){

    }

    public static MemoryCellTypeDaoImpl getInstance(){
        return memoryCellTypeDao != null ? memoryCellTypeDao : (memoryCellTypeDao = new MemoryCellTypeDaoImpl());
    }

    @Override
    public MemoryCellType getMemoryCellTypeById(Long id) {
        return SessionFactoryAccess.getSessionFactory().openSession().get(MemoryCellType.class, id);
    }

    @Override
    public void deleteMemoryCellType(Long id) {
        MemoryCellType memoryCellType = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((memoryCellType = getMemoryCellTypeById(id)) != null){
            session.beginTransaction();
            session.delete(memoryCellType);
            session.getTransaction().commit();
        } else {

        }
        session.close();
    }

    @Override
    public void saveMemory(MemoryCellType memoryCellType) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(memoryCellType);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<MemoryCellType> getAllMemoryCellTypes() {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MemoryCellType> query = builder.createQuery(MemoryCellType.class);
        Root<MemoryCellType> root = query.from(MemoryCellType.class);
        return session.createQuery(query.select(root)).list();
    }

    @Override
    public void updateMemoryCellType(MemoryCellType memoryCellType) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(memoryCellType);
        session.getTransaction().commit();
        session.close();
    }
}
