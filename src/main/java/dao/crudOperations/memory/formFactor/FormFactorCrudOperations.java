package dao.crudOperations.memory.formFactor;

import entity.memory.FormFactor;

import java.util.List;
import java.util.Set;

public interface FormFactorCrudOperations {
    FormFactor getFormFactorById(Long id);
    void deleteFormFactor(Long id);
    void saveFormFactor(FormFactor formFactor);
    List<FormFactor> getAllFormFactors();
    void updateFormFactor(FormFactor formFactor);
}
