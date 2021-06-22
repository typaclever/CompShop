package dao.crudOperations.graphics.purpose;

import entity.graphics.GraphicsBrand;
import entity.graphics.Purpose;

import java.util.Set;

public interface PurposeCrudOperations {
    Purpose getPurposeById(Long id);
    void deletePurpose(Long id);
    void savePurpose(Purpose purpose);
    Set<Purpose> getAllPurposes();
    void updatePurpose(Purpose purpose);
}
