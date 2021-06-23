package dao.daoImpl.operationSystem.operationSystemBrand;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.operationSystem.operationSystemBrand.OSBrandCrudOperations;
import entity.graphics.GPUManufacturer;
import entity.operationSystem.OSBrand;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
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
    public List<OSBrand> getAllOSBrands() {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<OSBrand> gpuManufacturerCriteriaQuery = builder.createQuery(OSBrand.class);
        Root<OSBrand> manufacturerRoot = gpuManufacturerCriteriaQuery.from(OSBrand.class);
        return session.createQuery(gpuManufacturerCriteriaQuery.select(manufacturerRoot)).list();
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
