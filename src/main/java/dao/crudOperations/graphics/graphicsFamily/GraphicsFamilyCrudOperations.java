package dao.crudOperations.graphics.graphicsFamily;

import entity.graphics.GraphicsBrand;
import entity.graphics.GraphicsFamily;

import java.util.List;
import java.util.Set;

public interface GraphicsFamilyCrudOperations {
    GraphicsFamily getGraphicsFamilyById(Long id);

    void deleteGraphicsFamily(Long id);

    void saveGraphicsFamily(GraphicsFamily graphicsFamily);

    List<GraphicsFamily> getAllGraphicsFamilies();

    void updateGraphicsFamily(GraphicsFamily graphicsFamily);
}
