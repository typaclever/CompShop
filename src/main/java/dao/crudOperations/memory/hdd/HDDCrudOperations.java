package dao.crudOperations.memory.hdd;

import entity.memory.HDD;
import entity.memory.mainEntity.Memory;

import java.util.List;
import java.util.Set;

public interface HDDCrudOperations {
    HDD getHDDById(Long id);
    void deleteHDD(Long id);
    void saveHDD(HDD hdd);
    List<HDD> getAllHDDs();
    void updateHDD(HDD hdd);
}
