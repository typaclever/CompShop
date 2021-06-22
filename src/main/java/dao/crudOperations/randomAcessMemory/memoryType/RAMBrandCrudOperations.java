package dao.crudOperations.randomAcessMemory.memoryType;

import entity.randomAccessMemory.RAMBrand;

import java.util.List;
import java.util.Set;

public interface RAMBrandCrudOperations {
    RAMBrand getRAMBrandById(Long id);
    void deleteRAMBrand(Long id);
    void saveRAMBrand(RAMBrand ramBrand);
    List<RAMBrand> getAllRAMBrands();
    void updateRAMBrand(RAMBrand ramBrand);
}
