package dao.crudOperations.memory.memory;

import entity.memory.mainEntity.Memory;

import java.util.Set;

public interface MemoryCrudOperations {
    Memory getMemoryById(Long id);
    void deleteMemory(Long id);
    void saveMemory(Memory memory);
    Set<Memory> getAllMemories();
    void updateMemory(Memory memory);
}
