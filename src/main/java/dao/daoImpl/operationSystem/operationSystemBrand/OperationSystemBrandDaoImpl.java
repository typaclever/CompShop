package dao.daoImpl.operationSystem.operationSystemBrand;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.operationSystem.operationSystemBrand.OSBrandCrudOperations;
import entity.operationSystem.OSBrand;
import org.hibernate.Session;

import java.util.Set;

public class OperationSystemBrandDaoImpl implements OSBrandCrudOperations {

    private static OperationSystemBrandDaoImpl operationSystemBrandDao;

    private OperationSystemBrandDaoImpl() {

    }

    public static OperationSystemBrandDaoImpl getInstance() {
        return operationSystemBrandDao != null ? operationSystemBrandDao
                : (operationSystemBrandDao = new OperationSystemBrandDaoImpl());
    }

    @Override
    public OSBrand getOSBrandById(Long id) {
        return SessionFactoryAccess.getSessionFactory().openSession().get(OSBrand.class, id);
    }

    @Override
    public void deleteOSBrand(Long id) {
        OSBrand brand = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((brand = getOSBrandById(id)) != null){
            session.beginTransaction();
            session.delete(brand);
            session.getTransaction().commit();
        } else {

        }
        session.close();
    }

    @Override
    public void saveOSBrand(OSBrand osBrand) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(osBrand);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Set<OSBrand> getAllOSBrands() {
        return null;
    }

    @Override
    public void updateOSBrand(OSBrand osBrand) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(osBrand);
        session.getTransaction().commit();
        session.close();
    }
}
