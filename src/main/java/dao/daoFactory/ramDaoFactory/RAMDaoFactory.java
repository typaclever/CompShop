package dao.daoFactory.ramDaoFactory;

import dao.daoImpl.randomAcessMemory.memoryType.MemoryTypeDaoImpl;
import dao.daoImpl.randomAcessMemory.ramBrand.RAMBrandDaoImpl;
import dao.daoImpl.randomAcessMemory.randomAcessMemory.RandomAccessMemoryDaoImpl;
import entity.randomAccessMemory.mainEntity.RandomAccessMemory;

public interface RAMDaoFactory {
    MemoryTypeDaoImpl getMemoryTypeDao();
    RAMBrandDaoImpl getRAMBrandDao();
    RandomAccessMemoryDaoImpl getRandomAccessMemoryDao();
}
