package dao.daoImpl.randomAcessMemory.ramBrand;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.randomAcessMemory.memoryType.RAMBrandCrudOperations;
import entity.graphics.GraphicsBrand;
import entity.randomAccessMemory.RAMBrand;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class RAMBrandDaoImpl implements RAMBrandCrudOperations {

    private static RAMBrandDaoImpl ramBrandDao;

    private RAMBrandDaoImpl() {

    }

    public static RAMBrandDaoImpl getInstance() {
        return ramBrandDao != null ? ramBrandDao : (ramBrandDao = new RAMBrandDaoImpl());
    }

    @Override
    public RAMBrand getRAMBrandById(Long id) {
        return SessionFactoryAccess.getSessionFactory().openSession().get(RAMBrand.class, id);
    }

    @Override
    public void deleteRAMBrand(Long id) {
        RAMBrand ramBrand = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((ramBrand = getRAMBrandById(id)) != null) {
            session.beginTransaction();
            session.delete(ramBrand);
            session.getTransaction().commit();
        } else {

        }
        session.close();
    }

    @Override
    public void saveRAMBrand(RAMBrand ramBrand) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(ramBrand);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<RAMBrand> getAllRAMBrands() {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<RAMBrand> query = builder.createQuery(RAMBrand.class);
        Root<RAMBrand> root = query.from(RAMBrand.class);
        return session.createQuery(query.select(root)).list();
    }

    @Override
    public void updateRAMBrand(RAMBrand ramBrand) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(ramBrand);
        session.getTransaction().commit();
        session.close();
    }
}
