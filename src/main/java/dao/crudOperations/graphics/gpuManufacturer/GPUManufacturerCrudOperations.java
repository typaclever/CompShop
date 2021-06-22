package dao.crudOperations.graphics.gpuManufacturer;

import entity.graphics.GPUManufacturer;

import java.util.List;
import java.util.Set;

public interface GPUManufacturerCrudOperations {
    GPUManufacturer getGPUManufacturerById(Long id);

    void deleteGPUManufacturer(Long id);

    void saveGPUManufacturer(GPUManufacturer gpuManufacturer);

    List<GPUManufacturer> getAllGPUManufacturer();

    void updateGPUManufacturer(GPUManufacturer gpuManufacturer);
}
