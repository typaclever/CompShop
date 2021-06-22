package dao.daoFactory.processorDaoFactory;

import dao.daoImpl.processor.processorBrand.ProcessorBrandDaoImpl;
import dao.daoImpl.processor.series.SeriesDaoImpl;
import dao.daoImpl.processor.model.ModelDaoImpl;
import dao.daoImpl.processor.processor.ProcessorDaoImpl;
import dao.daoImpl.processor.processorFamily.ProcessorFamilyDaoImpl;

public interface ProcessorDaoFactory {
    ProcessorDaoImpl getProcessorDao();
    ProcessorFamilyDaoImpl getProcessorFamilyDao();
    ModelDaoImpl getModelDao();
    SeriesDaoImpl getSeriesDao();
    ProcessorBrandDaoImpl getProcessorBrandDao();
}
