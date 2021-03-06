package dao.crudOperations.processor.processor;

import entity.processor.mainEntity.Processor;

import java.util.List;
import java.util.Set;

public interface ProcessorCrudOperations {
    Processor getProcessorById(Long id);
    void deleteProcessor(Long id);
    void saveProcessor(Processor processor);
    List<Processor> getAllProcessor();
    void updateProcessor(Processor processor);
}
