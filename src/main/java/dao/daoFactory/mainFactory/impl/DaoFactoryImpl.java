package dao.daoFactory.mainFactory.impl;

import dao.daoFactory.graphicsDaoFactory.GraphicsDaoFactory;
import dao.daoFactory.graphicsDaoFactory.impl.GraphicsDaoFactoryImpl;
import dao.daoFactory.mainFactory.DaoFactory;
import dao.daoFactory.memoryDaoFactory.MemoryDaoFactory;
import dao.daoFactory.memoryDaoFactory.impl.MemoryDaoFactoryImpl;
import dao.daoFactory.operationSystemDaoFactory.OperationSystemDaoFactory;
import dao.daoFactory.operationSystemDaoFactory.impl.OperationSystemDaoFactoryImpl;
import dao.daoFactory.processorDaoFactory.ProcessorDaoFactory;
import dao.daoFactory.processorDaoFactory.impl.ProcessorDaoFactoryImpl;
import dao.daoFactory.ramDaoFactory.RAMDaoFactory;
import dao.daoFactory.ramDaoFactory.RAMDaoFactoryImpl.RAMDaoFactoryImpl;

public class DaoFactoryImpl implements DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactoryImpl() {

    }

    public static synchronized DaoFactory getInstance() {
        return daoFactory != null ? daoFactory : (daoFactory = new DaoFactoryImpl());
    }

    @Override
    public MemoryDaoFactory getMemoryDaoFactory() {
        return MemoryDaoFactoryImpl.getInstance();
    }

    @Override
    public OperationSystemDaoFactory getOperationSystemDaoFactory() {
        return OperationSystemDaoFactoryImpl.getInstance();
    }

    @Override
    public ProcessorDaoFactory getProcessorDaoFactory() {
        return ProcessorDaoFactoryImpl.getInstance();
    }

    @Override
    public RAMDaoFactory getRAMDaoFactory() {
        return RAMDaoFactoryImpl.getInstance();
    }

    @Override
    public GraphicsDaoFactory getGraphicsDaoFactory() {
        return GraphicsDaoFactoryImpl.getInstance();
    }
}
