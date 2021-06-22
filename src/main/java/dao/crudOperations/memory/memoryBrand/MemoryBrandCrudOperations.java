package dao.crudOperations.memory.memoryBrand;

import entity.memory.MemoryBrand;
import entity.memory.mainEntity.Memory;

import java.util.Set;

public interface MemoryBrandCrudOperations {
    MemoryBrand getMemoryBrandById(Long id);
    void deleteMemoryBrand(Long id);
    void saveMemoryBrand(MemoryBrand memoryBrand);
    Set<MemoryBrand> getAllMemoryBrands();
    void updateMemoryBrand(MemoryBrand memoryBrand);
}
