package dao.daoImpl.memory.memoryCellType;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.memory.memoryCellType.MemoryCellTypeCrudOperations;
import entity.memory.MemoryCellType;
import org.hibernate.Session;

import java.util.Set;

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
    public Set<MemoryCellType> getAllMemoryCellTypes() {
        return null;
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
