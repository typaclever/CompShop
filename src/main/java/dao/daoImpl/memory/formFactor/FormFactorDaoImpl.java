package dao.daoImpl.memory.formFactor;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.memory.formFactor.FormFactorCrudOperations;
import entity.graphics.GraphicsBrand;
import entity.memory.FormFactor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class FormFactorDaoImpl implements FormFactorCrudOperations {

    private static FormFactorDaoImpl formFactorDao;

    private FormFactorDaoImpl() {

    }

    public static FormFactorDaoImpl getInstance() {
        return formFactorDao != null ? formFactorDao : (formFactorDao = new FormFactorDaoImpl());
    }

    @Override
    public FormFactor getFormFactorById(Long id) {
        return SessionFactoryAccess.getSessionFactory().openSession().get(FormFactor.class, id);
    }

    @Override
    public void deleteFormFactor(Long id) {
        FormFactor formFactor = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((formFactor = getFormFactorById(id)) != null) {
            session.beginTransaction();
            session.delete(formFactor);
            session.getTransaction().commit();
        } else {

        }
        session.close();
    }

    @Override
    public void saveFormFactor(FormFactor formFactor) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(formFactor);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<FormFactor> getAllFormFactors() {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<FormFactor> query = builder.createQuery(FormFactor.class);
        Root<FormFactor> root = query.from(FormFactor.class);
        return session.createQuery(query.select(root)).list();
    }

    @Override
    public void updateFormFactor(FormFactor formFactor) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(formFactor);
        session.getTransaction().commit();
        session.close();
    }
}
