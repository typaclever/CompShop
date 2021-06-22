package dao.crudOperations.memory.memoryBrand;

import entity.memory.MemoryBrand;
import entity.memory.mainEntity.Memory;

import java.util.List;
import java.util.Set;

public interface MemoryBrandCrudOperations {
    MemoryBrand getMemoryBrandById(Long id);
    void deleteMemoryBrand(Long id);
    void saveMemoryBrand(MemoryBrand memoryBrand);
    List<MemoryBrand> getAllMemoryBrands();
    void updateMemoryBrand(MemoryBrand memoryBrand);
}
