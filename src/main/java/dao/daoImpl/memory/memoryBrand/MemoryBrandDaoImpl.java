package dao.daoImpl.memory.memoryBrand;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.memory.memoryBrand.MemoryBrandCrudOperations;
import entity.graphics.GraphicsBrand;
import entity.memory.MemoryBrand;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class MemoryBrandDaoImpl implements MemoryBrandCrudOperations{

    private static MemoryBrandDaoImpl memoryBrandDao;

    private MemoryBrandDaoImpl(){

    }

    public static MemoryBrandDaoImpl getInstance() {
        return memoryBrandDao != null ? memoryBrandDao : (memoryBrandDao = new MemoryBrandDaoImpl());
    }

    @Override
    public MemoryBrand getMemoryBrandById(Long id) {
        return SessionFactoryAccess.getSessionFactory().openSession().get(MemoryBrand.class, id);
    }

    @Override
    public void deleteMemoryBrand(Long id) {
        MemoryBrand memoryBrand = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((memoryBrand = getMemoryBrandById(id)) != null){
            session.beginTransaction();
            session.delete(memoryBrand);
            session.getTransaction().commit();
        } else {

        }
        session.close();
    }

    @Override
    public void saveMemoryBrand(MemoryBrand memoryBrand) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(memoryBrand);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<MemoryBrand> getAllMemoryBrands() {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MemoryBrand> query = builder.createQuery(MemoryBrand.class);
        Root<MemoryBrand> root = query.from(MemoryBrand.class);
        return session.createQuery(query.select(root)).list();
    }

    @Override
    public void updateMemoryBrand(MemoryBrand memoryBrand) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(memoryBrand);
        session.getTransaction().commit();
        session.close();
    }
}
