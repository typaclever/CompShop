package dao.daoImpl.graphics.graphicsChip;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.graphics.graphicsChip.GraphicsChipCrudOperations;
import entity.graphics.GraphicsBrand;
import entity.graphics.GraphicsChip;
import org.hibernate.Session;
import sun.misc.GC;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class GraphicsChipDaoImpl implements GraphicsChipCrudOperations {

    private static GraphicsChipDaoImpl graphicsChipDao;

    private GraphicsChipDaoImpl() {

    }

    public static GraphicsChipDaoImpl getInstance() {
        return graphicsChipDao != null ? graphicsChipDao : (graphicsChipDao = new GraphicsChipDaoImpl());
    }

    @Override
    public GraphicsChip getGraphicsChipById(Long id) {
        return SessionFactoryAccess.getSessionFactory().openSession().get(GraphicsChip.class, id);
    }

    @Override
    public void deleteGraphicsChip(Long id) {
        GraphicsChip graphicsChip = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((graphicsChip = getGraphicsChipById(id)) != null) {
            session.beginTransaction();
            session.delete(graphicsChip);
            session.getTransaction().commit();
        } else {

        }
        session.close();
    }

    @Override
    public void saveGraphicsChip(GraphicsChip graphicsChip) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(graphicsChip);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<GraphicsChip> getAllGraphicsChips() {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<GraphicsChip> query = builder.createQuery(GraphicsChip.class);
        Root<GraphicsChip> root = query.from(GraphicsChip.class);
        return session.createQuery(query.select(root)).list();
    }

    @Override
    public void updateGraphicsChip(GraphicsChip graphicsChip) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(graphicsChip);
        session.getTransaction().commit();
        session.close();
    }
}
