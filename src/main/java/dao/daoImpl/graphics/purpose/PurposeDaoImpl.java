package dao.daoImpl.graphics.purpose;

import com.sun.xml.internal.ws.api.message.saaj.SAAJFactory;
import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.graphics.purpose.PurposeCrudOperations;
import dao.crudOperations.processor.processor.ProcessorCrudOperations;
import entity.graphics.GraphicsBrand;
import entity.graphics.Purpose;
import entity.processor.mainEntity.Processor;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
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
    public List<Purpose> getAllPurposes() {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Purpose> query = builder.createQuery(Purpose.class);
        Root<Purpose> root = query.from(Purpose.class);
        return session.createQuery(query.select(root)).list();
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
