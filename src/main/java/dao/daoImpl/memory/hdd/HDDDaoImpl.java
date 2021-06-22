package dao.daoImpl.memory.hdd;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.memory.hdd.HDDCrudOperations;
import entity.graphics.GraphicsBrand;
import entity.memory.HDD;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class HDDDaoImpl implements HDDCrudOperations {

    private static HDDDaoImpl hddDao;

    private HDDDaoImpl(){

    }

    public static HDDDaoImpl getInstance() {
        return hddDao != null ? hddDao : (hddDao = new HDDDaoImpl());
    }

    @Override
    public HDD getHDDById(Long id) {
        return SessionFactoryAccess.getSessionFactory().openSession().get(HDD.class, id);
    }

    @Override
    public void deleteHDD(Long id) {
        HDD hdd = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((hdd = getHDDById(id)) != null){
            session.beginTransaction();
            session.delete(hdd);
            session.getTransaction().commit();
        } else {

        }
        session.close();
    }

    @Override
    public void saveHDD(HDD hdd) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(hdd);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<HDD> getAllHDDs() {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HDD> query = builder.createQuery(HDD.class);
        Root<HDD> root = query.from(HDD.class);
        return session.createQuery(query.select(root)).list();
    }

    @Override
    public void updateHDD(HDD hdd) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(hdd);
        session.getTransaction().commit();
        session.close();
    }
}
