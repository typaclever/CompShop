package dao.daoImpl.processor.model;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.processor.model.ModelCrudOperations;
import entity.graphics.GraphicsBrand;
import entity.processor.Model;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class ModelDaoImpl implements ModelCrudOperations {

    private static ModelDaoImpl modelDao;

    private ModelDaoImpl(){

    }

    public static ModelDaoImpl getInstance(){
        return modelDao != null ? modelDao : (modelDao = new ModelDaoImpl());
    }

    @Override
    public Model getModelById(Long id) {
        return SessionFactoryAccess.getSessionFactory().openSession().get(Model.class, id);
    }

    @Override
    public void deleteModel(Long id) {
        Model model = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((model = getModelById(id)) != null){
            session.beginTransaction();
            session.delete(model);
            session.getTransaction().commit();
        } else {

        }
        session.close();
    }

    @Override
    public void saveModel(Model model) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(model);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Model> getAllModels() {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Model> query = builder.createQuery(Model.class);
        Root<Model> root = query.from(Model.class);
        return session.createQuery(query.select(root)).list();
    }

    @Override
    public void updateModel(Model model) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(model);
        session.getTransaction().commit();
        session.close();
    }
}
