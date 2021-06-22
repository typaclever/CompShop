package dao.daoFactory.mainFactory;

import dao.daoFactory.graphicsDaoFactory.GraphicsDaoFactory;
import dao.daoFactory.memoryDaoFactory.MemoryDaoFactory;
import dao.daoFactory.operationSystemDaoFactory.OperationSystemDaoFactory;
import dao.daoFactory.processorDaoFactory.ProcessorDaoFactory;
import dao.daoFactory.ramDaoFactory.RAMDaoFactory;

public interface DaoFactory {

    MemoryDaoFactory getMemoryDaoFactory();

    OperationSystemDaoFactory getOperationSystemDaoFactory();

    ProcessorDaoFactory getProcessorDaoFactory();

    RAMDaoFactory getRAMDaoFactory();

    GraphicsDaoFactory getGraphicsDaoFactory();
}
