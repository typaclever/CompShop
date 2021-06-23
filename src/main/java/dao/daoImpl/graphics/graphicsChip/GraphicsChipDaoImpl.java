package dao.daoImpl.graphics.graphicsChip;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.graphics.graphicsChip.GraphicsChipCrudOperations;
import entity.graphics.GraphicsChip;
import org.hibernate.Session;

import java.util.Set;

public class GraphicsChipDaoImpl implements GraphicsChipCrudOperations {

    private static GraphicsChipDaoImpl graphicsChipDao;

    private GraphicsChipDaoImpl(){

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
        if ((graphicsChip = getGraphicsChipById(id))!= null){
            session.beginTransaction();
            session.delete(graphicsChip);
            session.getTransaction().commit();
        }else {

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
    public Set<GraphicsChip> getAllGraphicsChips() {
        return null;
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
