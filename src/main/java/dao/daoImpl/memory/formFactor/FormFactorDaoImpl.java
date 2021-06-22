package dao.daoImpl.memory.formFactor;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.memory.formFactor.FormFactorCrudOperations;
import entity.memory.FormFactor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
    public Set<FormFactor> getAllFormFactors() {
        return null;
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
