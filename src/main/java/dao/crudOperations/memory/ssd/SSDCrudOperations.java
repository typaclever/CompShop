package dao.crudOperations.memory.ssd;

import entity.memory.SSD;

import java.util.Set;

public interface SSDCrudOperations {
    SSD getSSDById(Long id);

    void deleteSSD(Long id);

    void saveSSD(SSD ssd);

    Set<SSD> getAllSSDs();

    void updateSSD(SSD ssd);
}
