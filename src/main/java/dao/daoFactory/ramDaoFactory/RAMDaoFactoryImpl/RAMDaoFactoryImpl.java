package dao.daoFactory.ramDaoFactory.RAMDaoFactoryImpl;

import dao.daoFactory.ramDaoFactory.RAMDaoFactory;
import dao.daoImpl.randomAcessMemory.memoryType.MemoryTypeDaoImpl;
import dao.daoImpl.randomAcessMemory.ramBrand.RAMBrandDaoImpl;
import dao.daoImpl.randomAcessMemory.randomAcessMemory.RandomAccessMemoryDaoImpl;

public class RAMDaoFactoryImpl implements RAMDaoFactory {

    private static RAMDaoFactory ramDaoFactory;

    private RAMDaoFactoryImpl(){

    }

    public static RAMDaoFactory getInstance(){
        return ramDaoFactory != null ? ramDaoFactory : (ramDaoFactory = new RAMDaoFactoryImpl());
    }

    @Override
    public MemoryTypeDaoImpl getMemoryTypeDao() {
        return MemoryTypeDaoImpl.getInstance();
    }

    @Override
    public RAMBrandDaoImpl getRAMBrandDao() {
        return RAMBrandDaoImpl.getInstance();
    }

    @Override
    public RandomAccessMemoryDaoImpl getRandomAccessMemoryDao() {
        return RandomAccessMemoryDaoImpl.getInstance();
    }
}
