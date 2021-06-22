package dao.daoImpl.graphics.graphicsFamily;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.graphics.graphicsFamily.GraphicsFamilyCrudOperations;
import entity.graphics.GraphicsBrand;
import entity.graphics.GraphicsFamily;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class GraphicsFamilyDaoImpl implements GraphicsFamilyCrudOperations {

    private static GraphicsFamilyDaoImpl graphicsFamilyDao;

    public static GraphicsFamilyDaoImpl getInstance() {
        return graphicsFamilyDao != null ? graphicsFamilyDao : (graphicsFamilyDao = new GraphicsFamilyDaoImpl());
    }

    private GraphicsFamilyDaoImpl() {

    }

    @Override
    public GraphicsFamily getGraphicsFamilyById(Long id) {
        return SessionFactoryAccess.getSessionFactory().openSession().get(GraphicsFamily.class, id);
    }

    @Override
    public void deleteGraphicsFamily(Long id) {
        GraphicsFamily graphicsFamily = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((graphicsFamily = getGraphicsFamilyById(id)) != null) {
            session.beginTransaction();
            session.delete(graphicsFamily);
            session.getTransaction().commit();
        }
        session.close();
    }

    @Override
    public void saveGraphicsFamily(GraphicsFamily graphicsFamily) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(graphicsFamily);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<GraphicsFamily> getAllGraphicsFamilies() {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<GraphicsFamily> query = builder.createQuery(GraphicsFamily.class);
        Root<GraphicsFamily> root = query.from(GraphicsFamily.class);
        return session.createQuery(query.select(root)).list();
    }

    @Override
    public void updateGraphicsFamily(GraphicsFamily graphicsFamily) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(graphicsFamily);
        session.getTransaction().commit();
        session.close();
    }
}
