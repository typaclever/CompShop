package dao.daoFactory.operationSystemDaoFactory.impl;

import dao.daoFactory.operationSystemDaoFactory.OperationSystemDaoFactory;
import dao.daoImpl.operationSystem.operationSystem.OperationSystemDaoImpl;
import dao.daoImpl.operationSystem.operationSystemBrand.OperationSystemBrandDaoImpl;

public class OperationSystemDaoFactoryImpl implements OperationSystemDaoFactory {

    private static OperationSystemDaoFactory operationSystemDaoFactory;

    private OperationSystemDaoFactoryImpl(){
    }

    public static OperationSystemDaoFactory getInstance(){
        return operationSystemDaoFactory != null ? operationSystemDaoFactory
                : ( operationSystemDaoFactory = new OperationSystemDaoFactoryImpl());
    }

    @Override
    public OperationSystemDaoImpl getOperationSystemDao() {
        return OperationSystemDaoImpl.getInstance();
    }

    @Override
    public OperationSystemBrandDaoImpl getOperationSystemBrandDao() {
        return OperationSystemBrandDaoImpl.getInstance();
    }
}
