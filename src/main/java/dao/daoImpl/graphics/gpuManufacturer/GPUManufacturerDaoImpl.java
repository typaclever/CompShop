package dao.daoImpl.graphics.gpuManufacturer;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.graphics.gpuManufacturer.GPUManufacturerCrudOperations;
import entity.graphics.GPUManufacturer;
import org.hibernate.Session;

import java.util.Set;

public class GPUManufacturerDaoImpl implements GPUManufacturerCrudOperations {

    private static GPUManufacturerDaoImpl gpuManufacturerDao;

    private GPUManufacturerDaoImpl(){

    }

    private static GPUManufacturerDaoImpl getInstance() {
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
    public Set<GPUManufacturer> getAllGPUManufacturer() {
        return null;
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
