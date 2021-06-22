package dao.crudOperations.memory.memoryCellType;

import entity.memory.MemoryCellType;

import java.util.List;

public interface MemoryCellTypeCrudOperations {
    MemoryCellType getMemoryCellTypeById(Long id);

    void deleteMemoryCellType(Long id);

    void saveMemory(MemoryCellType memoryCellType);

    List<MemoryCellType> getAllMemoryCellTypes();

    void updateMemoryCellType(MemoryCellType memoryCellType);
}
