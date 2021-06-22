package dao.crudOperations.memory.formFactor;

import entity.memory.FormFactor;

import java.util.Set;

public interface FormFactorCrudOperations {
    FormFactor getFormFactorById(Long id);
    void deleteFormFactor(Long id);
    void saveFormFactor(FormFactor formFactor);
    Set<FormFactor> getAllFormFactors();
    void updateFormFactor(FormFactor formFactor);
}
