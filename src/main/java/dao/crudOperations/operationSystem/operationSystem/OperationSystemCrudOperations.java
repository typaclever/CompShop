package dao.crudOperations.operationSystem.operationSystem;

import entity.operationSystem.mainEntity.OperationSystem;

import java.util.List;
import java.util.Set;

public interface OperationSystemCrudOperations {
    OperationSystem getOperationSystemById(Long id);
    void deleteOperationSystem(Long id);
    void saveOperationSystem(OperationSystem operationSystem);
    List<OperationSystem> getAllOperationSystems();
    void updateOperationSystem(OperationSystem operationSystem);
}
