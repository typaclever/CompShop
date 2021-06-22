package dao.daoFactory.graphicsDaoFactory.impl;

import dao.daoFactory.graphicsDaoFactory.GraphicsDaoFactory;
import dao.daoImpl.graphics.gpuManufacturer.GPUManufacturerDaoImpl;
import dao.daoImpl.graphics.graphics.GraphicsDaoImpl;
import dao.daoImpl.graphics.graphicsBrand.GraphicsBrandDaoImpl;
import dao.daoImpl.graphics.graphicsChip.GraphicsChipDaoImpl;
import dao.daoImpl.graphics.graphicsFamily.GraphicsFamilyDaoImpl;

public class GraphicsDaoFactoryImpl implements GraphicsDaoFactory {

    private static GraphicsDaoFactory graphicsDaoFactory;

    private GraphicsDaoFactoryImpl(){

    }

    public static GraphicsDaoFactory getInstance(){
        return graphicsDaoFactory != null ? graphicsDaoFactory : (graphicsDaoFactory = new GraphicsDaoFactoryImpl());
    }

    @Override
    public GPUManufacturerDaoImpl GPUManufacturerDao() {
        return GPUManufacturerDaoImpl.getInstance();
    }

    @Override
    public GraphicsDaoImpl getGraphicsDao() {
        return GraphicsDaoImpl.getInstance();
    }

    @Override
    public GraphicsBrandDaoImpl getGraphicsBrandDao() {
        return GraphicsBrandDaoImpl.getInstance();
    }

    @Override
    public GraphicsChipDaoImpl getGraphicsChipDao() {
        return GraphicsChipDaoImpl.getInstance();
    }

    @Override
    public GraphicsFamilyDaoImpl getGraphicsFamilyDao() {
        return GraphicsFamilyDaoImpl.getInstance();
    }

}
