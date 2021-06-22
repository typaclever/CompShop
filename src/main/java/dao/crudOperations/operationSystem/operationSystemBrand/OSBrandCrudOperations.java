package dao.crudOperations.operationSystem.operationSystemBrand;

import entity.operationSystem.OSBrand;

import java.util.Set;

public interface OSBrandCrudOperations {
    OSBrand getOSBrandById(Long id);
    void deleteOSBrand(Long id);
    void saveOSBrand(OSBrand osBrand);
    Set<OSBrand> getAllOSBrands();
    void updateOSBrand(OSBrand osBrand);
}
