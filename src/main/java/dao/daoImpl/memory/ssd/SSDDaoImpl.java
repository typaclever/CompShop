package dao.daoImpl.memory.ssd;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.memory.ssd.SSDCrudOperations;
import entity.graphics.GraphicsBrand;
import entity.memory.SSD;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
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
    public List<SSD> getAllSSDs() {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SSD> query = builder.createQuery(SSD.class);
        Root<SSD> root = query.from(SSD.class);
        return session.createQuery(query.select(root)).list();
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
