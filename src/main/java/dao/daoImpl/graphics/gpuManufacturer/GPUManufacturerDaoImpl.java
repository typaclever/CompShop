package dao.daoImpl.graphics.gpuManufacturer;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.graphics.gpuManufacturer.GPUManufacturerCrudOperations;
import entity.graphics.GPUManufacturer;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class GPUManufacturerDaoImpl implements GPUManufacturerCrudOperations {

    private static GPUManufacturerDaoImpl gpuManufacturerDao;

    private GPUManufacturerDaoImpl(){

    }

    public static GPUManufacturerDaoImpl getInstance() {
        return gpuManufacturerDao != null ? gpuManufacturerDao : (gpuManufacturerDao =  new GPUManufacturerDaoImpl());
    }

    @Override
    public GPUManufacturer getGPUManufacturerById(Long id) {
        return SessionFactoryAccess
                .getSessionFactory()
                .openSession()
                .get(GPUManufacturer.class, id);
    }

    @Override
    public void deleteGPUManufacturer(Long id) {
        GPUManufacturer gpuManufacturer = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((gpuManufacturer = getGPUManufacturerById(id)) != null){
            session.beginTransaction();
            session.delete(gpuManufacturer);
            session.getTransaction().commit();
        }else {

        }
        session.close();
    }

    @Override
    public void saveGPUManufacturer(GPUManufacturer gpuManufacturer) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(gpuManufacturer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<GPUManufacturer> getAllGPUManufacturer() {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<GPUManufacturer> gpuManufacturerCriteriaQuery = builder.createQuery(GPUManufacturer.class);
        Root<GPUManufacturer> manufacturerRoot = gpuManufacturerCriteriaQuery.from(GPUManufacturer.class);
        return session.createQuery(gpuManufacturerCriteriaQuery.select(manufacturerRoot)).list();
    }


    @Override
    public void updateGPUManufacturer(GPUManufacturer gpuManufacturer) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(gpuManufacturer);
        session.getTransaction().commit();
        session.close();
    }
}
