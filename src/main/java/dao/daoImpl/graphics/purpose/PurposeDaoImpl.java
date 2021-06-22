package dao.daoImpl.graphics.purpose;

import com.sun.xml.internal.ws.api.message.saaj.SAAJFactory;
import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.graphics.purpose.PurposeCrudOperations;
import dao.crudOperations.processor.processor.ProcessorCrudOperations;
import entity.graphics.Purpose;
import entity.processor.mainEntity.Processor;
import org.hibernate.Session;

import java.util.Set;

public class PurposeDaoImpl implements PurposeCrudOperations {

    private static PurposeDaoImpl purposeDao;

    private PurposeDaoImpl() {

    }

    public static PurposeDaoImpl getInstance() {
        return purposeDao != null ? purposeDao : (purposeDao = new PurposeDaoImpl());
    }

    @Override
    public Purpose getPurposeById(Long id) {
        return SessionFactoryAccess.getSessionFactory().openSession().get(Purpose.class, id);
    }

    @Override
    public void deletePurpose(Long id) {
        Purpose purpose = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((purpose = getPurposeById(id)) != null) {
            session.beginTransaction();
            session.delete(purpose);
            session.getTransaction().commit();
        } else {

        }
        session.close();
    }

    @Override
    public void savePurpose(Purpose purpose) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(purpose);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Set<Purpose> getAllPurposes() {
        return null;
    }

    @Override
    public void updatePurpose(Purpose purpose) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(purpose);
        session.getTransaction().commit();
        session.close();
    }
}
