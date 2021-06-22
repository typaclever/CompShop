package dao.daoImpl.processor.processorFamily;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.processor.processorFamily.ProcessorFamilyCrudOperations;
import entity.graphics.GraphicsBrand;
import entity.processor.ProcessorFamily;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class ProcessorFamilyDaoImpl implements ProcessorFamilyCrudOperations {

    private static ProcessorFamilyDaoImpl processorFamilyDao;

    private ProcessorFamilyDaoImpl() {

    }

    public static ProcessorFamilyDaoImpl getInstance() {
        return processorFamilyDao != null ? processorFamilyDao : (processorFamilyDao = new ProcessorFamilyDaoImpl());
    }

    @Override
    public ProcessorFamily getProcessorFamilyById(Long id) {
        return SessionFactoryAccess.getSessionFactory().openSession().get(ProcessorFamily.class, id);
    }

    @Override
    public void deleteProcessorFamily(Long id) {
        ProcessorFamily processorFamily = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((processorFamily = getProcessorFamilyById(id)) != null) {
            session.beginTransaction();
            session.delete(processorFamily);
            session.getTransaction().commit();
        } else {

        }
        session.close();
    }

    @Override
    public void saveProcessorFamily(ProcessorFamily processorFamily) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(processorFamily);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<ProcessorFamily> getAllProcessorFamilies() {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ProcessorFamily> query = builder.createQuery(ProcessorFamily.class);
        Root<ProcessorFamily> root = query.from(ProcessorFamily.class);
        return session.createQuery(query.select(root)).list();
    }

    @Override
    public void updateProcessorFamily(ProcessorFamily processorFamily) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(processorFamily);
        session.getTransaction().commit();
        session.close();
    }
}
