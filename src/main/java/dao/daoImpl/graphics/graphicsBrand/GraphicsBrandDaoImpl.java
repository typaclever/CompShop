package dao.daoImpl.graphics.graphicsBrand;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.graphics.graphicsBrand.GraphicsBrandCrudOperations;
import dao.daoImpl.graphics.graphicsChip.GraphicsChipDaoImpl;
import entity.graphics.GraphicsBrand;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Set;

public class GraphicsBrandDaoImpl implements GraphicsBrandCrudOperations {

    private static GraphicsBrandDaoImpl graphicsBrandDao;

    private GraphicsBrandDaoImpl(){

    }

    public static GraphicsBrandDaoImpl getInstance() {
        return graphicsBrandDao != null ? graphicsBrandDao : (graphicsBrandDao = new GraphicsBrandDaoImpl());
    }

    @Override
    public GraphicsBrand getGraphicsBrandById(Long id) {
        return SessionFactoryAccess.getSessionFactory().openSession().get(GraphicsBrand.class, id);
    }

    @Override
    public void deleteGraphicsBrand(Long id) {
        GraphicsBrand graphicsBrand = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((graphicsBrand = getGraphicsBrandById(id)) != null) {
            session.beginTransaction();
            session.delete(graphicsBrand);
            session.getTransaction().commit();
        } else {

        }
        session.close();
    }

    @Override
    public void saveGraphicsBrand(GraphicsBrand graphicsBrand) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(graphicsBrand);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Set<GraphicsBrand> getAllGraphicsBrand() {
        return null;
    }

    @Override
    public void updateGraphicsBrands(GraphicsBrand graphicsBrand) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(graphicsBrand);
        session.getTransaction().commit();
        session.close();
    }
}
