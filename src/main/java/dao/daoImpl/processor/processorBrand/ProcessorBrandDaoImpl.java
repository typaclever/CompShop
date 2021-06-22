package dao.daoImpl.processor.processorBrand;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.processor.processorBrand.ProcessorBrandCrudOperations;
import dao.daoImpl.processor.processor.ProcessorDaoImpl;
import entity.processor.ProcessorBrand;
import org.hibernate.Session;

import java.util.Set;

public class ProcessorBrandDaoImpl implements ProcessorBrandCrudOperations {

    private static ProcessorBrandDaoImpl processorBrandDao;

    private ProcessorBrandDaoImpl() {

    }

    public static ProcessorBrandDaoImpl getInstance() {
        return processorBrandDao != null ? processorBrandDao : (processorBrandDao = new ProcessorBrandDaoImpl());
    }

    @Override
    public ProcessorBrand getProcessorBrandById(Long id) {
        return SessionFactoryAccess.getSessionFactory().openSession().get(ProcessorBrand.class, id);
    }

    @Override
    public void deleteProcessorBrand(Long id) {
        ProcessorBrand processorBrand = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((processorBrand = getProcessorBrandById(id)) != null) {
            session.beginTransaction();
            session.delete(processorBrand);
            session.getTransaction().commit();
        } else {

        }
        session.close();
    }

    @Override
    public void saveProcessorBrand(ProcessorBrand processorBrand) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(processorBrand);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Set<ProcessorBrand> getAllProcessorBrands() {
        return null;
    }

    @Override
    public void updateProcessorBrand(ProcessorBrand processorBrand) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(processorBrand);
        session.getTransaction().commit();
        session.close();
    }
}
