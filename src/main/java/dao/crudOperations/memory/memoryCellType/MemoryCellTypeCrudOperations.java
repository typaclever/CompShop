package dao.crudOperations.memory.memoryCellType;

import entity.memory.MemoryCellType;

import java.util.Set;

public interface MemoryCellTypeCrudOperations {
    MemoryCellType getMemoryCellTypeById(Long id);

    void deleteMemoryCellType(Long id);

    void saveMemory(MemoryCellType memoryCellType);

    Set<MemoryCellType> getAllMemoryCellTypes();

    void updateMemoryCellType(MemoryCellType memoryCellType);
}
