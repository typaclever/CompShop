package dao.crudOperations.operationSystem.operationSystemBrand;

import entity.operationSystem.OSBrand;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Set;

public interface OSBrandCrudOperations {
    OSBrand getOSBrandById(Long id);
    void deleteOSBrand(Long id);
    void saveOSBrand(OSBrand osBrand);
    List<OSBrand> getAllOSBrands();
    void updateOSBrand(OSBrand osBrand);
}
