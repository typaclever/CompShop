package dao.crudOperations.memory.memory;

import entity.memory.mainEntity.Memory;

import java.util.List;
import java.util.Set;

public interface MemoryCrudOperations {
    Memory getMemoryById(Long id);
    void deleteMemory(Long id);
    void saveMemory(Memory memory);
    List<Memory> getAllMemories();
    void updateMemory(Memory memory);
}
