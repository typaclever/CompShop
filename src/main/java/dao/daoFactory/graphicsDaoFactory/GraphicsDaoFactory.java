package dao.daoFactory.graphicsDaoFactory;

import dao.daoImpl.graphics.gpuManufacturer.GPUManufacturerDaoImpl;
import dao.daoImpl.graphics.graphics.GraphicsDaoImpl;
import dao.daoImpl.graphics.graphicsBrand.GraphicsBrandDaoImpl;
import dao.daoImpl.graphics.graphicsChip.GraphicsChipDaoImpl;
import dao.daoImpl.graphics.graphicsFamily.GraphicsFamilyDaoImpl;

public interface GraphicsDaoFactory {
    GPUManufacturerDaoImpl GPUManufacturerDao();
    GraphicsDaoImpl getGraphicsDao();
    GraphicsBrandDaoImpl getGraphicsBrandDao();
    GraphicsChipDaoImpl getGraphicsChipDao();
    GraphicsFamilyDaoImpl getGraphicsFamilyDao();
}
