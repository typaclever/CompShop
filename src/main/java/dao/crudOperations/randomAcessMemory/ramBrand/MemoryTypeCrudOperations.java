package dao.crudOperations.randomAcessMemory.ramBrand;

import entity.memory.mainEntity.Memory;
import entity.randomAccessMemory.MemoryType;

import java.util.Set;

public interface MemoryTypeCrudOperations {
    MemoryType getMemoryTypeById(Long id);
    void deleteMemoryType(Long id);
    void saveMemoryType(MemoryType memoryType);
    Set<MemoryType> getAllMemoryTypes();
    void updateMemoryType(MemoryType memoryType);
}
