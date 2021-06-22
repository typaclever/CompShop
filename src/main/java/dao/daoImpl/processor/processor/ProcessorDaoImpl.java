package dao.daoImpl.processor.processor;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.processor.processor.ProcessorCrudOperations;
import entity.graphics.GraphicsBrand;
import entity.processor.mainEntity.Processor;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;


public class ProcessorDaoImpl implements ProcessorCrudOperations {

    private static ProcessorDaoImpl processorDao;

    private ProcessorDaoImpl() {
    }

    public static ProcessorDaoImpl getInstance() {
        return processorDao != null ? processorDao : (processorDao = new ProcessorDaoImpl());
    }

    @Override
    public Processor getProcessorById(Long id) {
        return SessionFactoryAccess.getSessionFactory().openSession().get(Processor.class, id);
    }

    @Override
    public void deleteProcessor(Long id) {
        Processor processor = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((processor = getProcessorById(id)) != null) {
            session.beginTransaction();
            session.delete(processor);
            session.getTransaction().commit();
        } else {

        }
        session.close();
    }

    @Override
    public void saveProcessor(Processor processor) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(processor);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Processor> getAllProcessor() {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Processor> query = builder.createQuery(Processor.class);
        Root<Processor> root = query.from(Processor.class);
        return session.createQuery(query.select(root)).list();
    }

    @Override
    public void updateProcessor(Processor processor) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(processor);
        session.getTransaction().commit();
        session.close();
    }
}
