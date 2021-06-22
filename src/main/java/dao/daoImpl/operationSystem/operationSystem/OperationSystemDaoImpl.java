package dao.daoImpl.operationSystem.operationSystem;

import dao.SessionFactoryAccess.SessionFactoryAccess;
import dao.crudOperations.operationSystem.operationSystem.OperationSystemCrudOperations;
import entity.operationSystem.mainEntity.OperationSystem;
import org.hibernate.Session;

import java.util.Set;

public class OperationSystemDaoImpl implements OperationSystemCrudOperations {

    private static OperationSystemDaoImpl operationSystemDao;

    private OperationSystemDaoImpl() {

    }

    public static OperationSystemDaoImpl getInstance() {
        return operationSystemDao != null ? operationSystemDao : (operationSystemDao = new OperationSystemDaoImpl());
    }

    @Override
    public OperationSystem getOperationSystemById(Long id) {
        return SessionFactoryAccess.getSessionFactory().openSession().get(OperationSystem.class, id);
    }

    @Override
    public void deleteOperationSystem(Long id) {
        OperationSystem operationSystem = null;
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        if ((operationSystem = getOperationSystemById(id)) != null) {
            session.beginTransaction();
            session.delete(operationSystem);
            session.getTransaction().commit();
        } else {

        }
        session.close();
    }

    @Override
    public void saveOperationSystem(OperationSystem operationSystem) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(operationSystem);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Set<OperationSystem> getAllOperationSystems() {
        return null;
    }

    @Override
    public void updateOperationSystem(OperationSystem operationSystem) {
        Session session = SessionFactoryAccess.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(operationSystem);
        session.getTransaction().commit();
        session.close();
    }
}
