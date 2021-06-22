package dao.crudOperations.processor.processorBrand;

import entity.processor.ProcessorBrand;

import java.util.List;
import java.util.Set;

public interface ProcessorBrandCrudOperations {
    ProcessorBrand getProcessorBrandById(Long id);
    void deleteProcessorBrand(Long id);
    void saveProcessorBrand(ProcessorBrand processorBrand);
    List<ProcessorBrand> getAllProcessorBrands();
    void updateProcessorBrand(ProcessorBrand processorBrand);
}
