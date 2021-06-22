package dao.crudOperations.processor.model;

import entity.processor.Model;

import java.util.List;
import java.util.Set;

public interface ModelCrudOperations {
    Model getModelById(Long id);
    void deleteModel(Long id);
    void saveModel(Model model);
    List<Model> getAllModels();
    void updateModel(Model model);
}
