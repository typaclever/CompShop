package dao.daoFactory.processorDaoFactory.impl;

import dao.daoFactory.mainFactory.DaoFactory;
import dao.daoFactory.mainFactory.impl.DaoFactoryImpl;
import dao.daoFactory.processorDaoFactory.ProcessorDaoFactory;
import dao.daoImpl.processor.model.ModelDaoImpl;
import dao.daoImpl.processor.processor.ProcessorDaoImpl;
import dao.daoImpl.processor.processorBrand.ProcessorBrandDaoImpl;
import dao.daoImpl.processor.processorFamily.ProcessorFamilyDaoImpl;
import dao.daoImpl.processor.series.SeriesDaoImpl;

public class ProcessorDaoFactoryImpl implements ProcessorDaoFactory {

    private static ProcessorDaoFactory processorDaoFactory;

    private ProcessorDaoFactoryImpl(){

    }

    public static ProcessorDaoFactory getInstance(){
        return processorDaoFactory != null ? processorDaoFactory
                : (processorDaoFactory = new ProcessorDaoFactoryImpl());
    }

    @Override
    public ProcessorDaoImpl getProcessorDao() {
        return ProcessorDaoImpl.getInstance();
    }

    @Override
    public ProcessorFamilyDaoImpl getProcessorFamilyDao() {
        return ProcessorFamilyDaoImpl.getInstance();
    }

    @Override
    public ModelDaoImpl getModelDao() {
        return ModelDaoImpl.getInstance();
    }

    @Override
    public SeriesDaoImpl getSeriesDao() {
        return SeriesDaoImpl.getInstance();
    }

    @Override
    public ProcessorBrandDaoImpl getProcessorBrandDao() {
        return ProcessorBrandDaoImpl.getInstance();
    }
}
