package dao.daoImpl.graphics.graphics;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.graphics.graphics.GraphicsCrudOperations;
import dao.daoImpl.graphics.gpuManufacturer.GPUManufacturerDaoImpl;
import entity.graphics.GPUManufacturer;
import entity.graphics.mainEntity.Graphics;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Set;

public class GraphicsDaoImpl implements GraphicsCrudOperations {

    private static GraphicsDaoImpl graphicsDao;

    private GraphicsDaoImpl(){

    }

    private static GraphicsDaoImpl getInstance() {
        return graphicsDao != null ? graphicsDao : (graphicsDao = new GraphicsDaoImpl());
    }

    @Override
    public Graphics getGraphicsById(Long id) {
        return SessionFactoryAccess.getSessionFactory().openSession().get(Graphics.class, id);
    }

    @Override
    public void deleteGraphics(Long id) {
        Graphics graphics = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((graphics = graphicsDao.getGraphicsById(id)) != null){
            session.beginTransaction();
            session.delete(graphics);
            session.getTransaction().commit();
        }else {

        }
        session.close();
    }

    @Override
    public void saveGraphics(Graphics graphics) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(graphics);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Set<Graphics> getAllGraphics() {
        return null;
    }

    @Override
    public void updateGraphics(Graphics graphics) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(graphics);
        session.getTransaction().commit();
        session.close();
    }
}
