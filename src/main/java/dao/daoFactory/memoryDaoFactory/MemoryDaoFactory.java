package dao.daoFactory.memoryDaoFactory;

import dao.daoImpl.memory.connectionInterface.ConnectionInterfaceDaoImpl;
import dao.daoImpl.memory.formFactor.FormFactorDaoImpl;
import dao.daoImpl.memory.hdd.HDDDaoImpl;
import dao.daoImpl.memory.memoryBrand.MemoryBrandDaoImpl;
import dao.daoImpl.memory.ssd.SSDDaoImpl;

public interface MemoryDaoFactory {
    ConnectionInterfaceDaoImpl getConnectionInterfaceDao();
    FormFactorDaoImpl getFormFactorDao();
    HDDDaoImpl getHDDDao();
    MemoryBrandDaoImpl getMemoryBrandDaoImpl();
    SSDDaoImpl getSSDDao();
}
