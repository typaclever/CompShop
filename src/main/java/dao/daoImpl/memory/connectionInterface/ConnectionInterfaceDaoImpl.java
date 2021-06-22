package dao.daoImpl.memory.connectionInterface;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.memory.connectionInterface.ConnectionInterfaceCrudOperations;
import entity.graphics.GraphicsBrand;
import entity.memory.ConnectionInterface;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Set;

public class ConnectionInterfaceDaoImpl implements ConnectionInterfaceCrudOperations {

    private static ConnectionInterfaceDaoImpl connectionInterfaceDao;

    private ConnectionInterfaceDaoImpl() {

    }

    public static ConnectionInterfaceDaoImpl getInstance() {
        return connectionInterfaceDao != null ? connectionInterfaceDao : (connectionInterfaceDao = new ConnectionInterfaceDaoImpl());
    }

    @Override
    public ConnectionInterface getConnectionInterfaceById(Long id) {
        return SessionFactoryAccess.getSessionFactory().openSession().get(ConnectionInterface.class, id);
    }

    @Override
    public void deleteConnectionInterface(Long id) {
        ConnectionInterface connectionInterface = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((connectionInterface = getConnectionInterfaceById(id)) != null){
            session.beginTransaction();
            session.delete(connectionInterface);
            session.getTransaction().commit();
        }else {

        }
        session.close();
    }

    @Override
    public void saveConnectionInterface(ConnectionInterface connectionInterface) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(connectionInterface);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<ConnectionInterface> getAllConnectionInterfaces() {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ConnectionInterface> query = builder.createQuery(ConnectionInterface.class);
        Root<ConnectionInterface> root = query.from(ConnectionInterface.class);
        return session.createQuery(query.select(root)).list();
    }

    @Override
    public void updateConnectionInterface(ConnectionInterface connectionInterface) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(connectionInterface);
        session.getTransaction().commit();
        session.close();
    }
}
