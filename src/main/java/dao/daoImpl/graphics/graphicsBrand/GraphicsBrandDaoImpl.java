package dao.daoImpl.graphics.graphicsBrand;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.graphics.graphicsBrand.GraphicsBrandCrudOperations;
import dao.daoImpl.graphics.graphicsChip.GraphicsChipDaoImpl;
import entity.graphics.GPUManufacturer;
import entity.graphics.GraphicsBrand;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
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
    public List<GraphicsBrand> getAllGraphicsBrand() {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<GraphicsBrand> query = builder.createQuery(GraphicsBrand.class);
        Root<GraphicsBrand> root = query.from(GraphicsBrand.class);
        return session.createQuery(query.select(root)).list();
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
