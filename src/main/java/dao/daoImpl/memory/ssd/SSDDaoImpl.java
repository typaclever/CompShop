package dao.daoImpl.memory.ssd;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.memory.ssd.SSDCrudOperations;
import entity.memory.SSD;
import org.hibernate.Session;

import java.util.Set;

public class SSDDaoImpl implements SSDCrudOperations {

    private static SSDDaoImpl ssdDao;

    private SSDDaoImpl(){

    }

    public static SSDDaoImpl getInstance(){
        return ssdDao != null ? ssdDao : (ssdDao = new SSDDaoImpl());
    }

    @Override
    public SSD getSSDById(Long id) {
        return SessionFactoryAccess.getSessionFactory().openSession().get(SSD.class, id);
    }

    @Override
    public void deleteSSD(Long id) {
        SSD ssd = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((ssd = getSSDById(id)) != null){
            session.beginTransaction();
            session.delete(ssd);
            session.getTransaction().commit();
        } else {

        }
        session.close();
    }

    @Override
    public void saveSSD(SSD ssd) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(ssd);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Set<SSD> getAllSSDs() {
        return null;
    }

    @Override
    public void updateSSD(SSD ssd) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(ssd);
        session.getTransaction().commit();
        session.close();
    }
}
