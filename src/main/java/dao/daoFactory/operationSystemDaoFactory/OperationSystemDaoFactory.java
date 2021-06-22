package dao.daoFactory.operationSystemDaoFactory;

import dao.daoImpl.operationSystem.operationSystem.OperationSystemDaoImpl;
import dao.daoImpl.operationSystem.operationSystemBrand.OperationSystemBrandDaoImpl;

public interface OperationSystemDaoFactory {
    OperationSystemDaoImpl getOperationSystemDao();
    OperationSystemBrandDaoImpl getOperationSystemBrandDao();
}
