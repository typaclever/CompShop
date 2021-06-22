package dao.daoFactory.memoryDaoFactory.impl;

import dao.daoFactory.memoryDaoFactory.MemoryDaoFactory;
import dao.daoImpl.memory.connectionInterface.ConnectionInterfaceDaoImpl;
import dao.daoImpl.memory.formFactor.FormFactorDaoImpl;
import dao.daoImpl.memory.hdd.HDDDaoImpl;
import dao.daoImpl.memory.memoryBrand.MemoryBrandDaoImpl;
import dao.daoImpl.memory.ssd.SSDDaoImpl;

public class MemoryDaoFactoryImpl implements MemoryDaoFactory {

    private static MemoryDaoFactory memoryDaoFactory;

    private MemoryDaoFactoryImpl() {

    }

    public static MemoryDaoFactory getInstance() {
        return memoryDaoFactory != null ? memoryDaoFactory : (memoryDaoFactory = new MemoryDaoFactoryImpl());
    }

    @Override
    public ConnectionInterfaceDaoImpl getConnectionInterfaceDao() {
        return ConnectionInterfaceDaoImpl.getInstance();
    }

    @Override
    public FormFactorDaoImpl getFormFactorDao() {
        return FormFactorDaoImpl.getInstance();
    }

    @Override
    public HDDDaoImpl getHDDDao() {
        return HDDDaoImpl.getInstance();
    }

    @Override
    public MemoryBrandDaoImpl getMemoryBrandDaoImpl() {
        return MemoryBrandDaoImpl.getInstance();
    }

    @Override
    public SSDDaoImpl getSSDDao() {
        return SSDDaoImpl.getInstance();
    }
}
