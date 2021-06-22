package dao.crudOperations.processor.processorFamily;


import entity.memory.mainEntity.Memory;
import entity.processor.ProcessorFamily;

import java.util.List;
import java.util.Set;

public interface ProcessorFamilyCrudOperations {
    ProcessorFamily getProcessorFamilyById(Long id);
    void deleteProcessorFamily(Long id);
    void saveProcessorFamily(ProcessorFamily processorFamily);
    List<ProcessorFamily> getAllProcessorFamilies();
    void updateProcessorFamily(ProcessorFamily processorFamily);
}
