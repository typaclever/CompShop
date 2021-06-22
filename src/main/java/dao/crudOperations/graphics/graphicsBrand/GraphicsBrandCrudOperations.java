package dao.crudOperations.graphics.graphicsBrand;

import entity.graphics.GraphicsBrand;

import java.util.List;
import java.util.Set;

public interface GraphicsBrandCrudOperations {
    GraphicsBrand getGraphicsBrandById(Long id);

    void deleteGraphicsBrand(Long id);

    void saveGraphicsBrand(GraphicsBrand graphicsBrand);

    List<GraphicsBrand> getAllGraphicsBrand();

    void updateGraphicsBrands(GraphicsBrand graphicsBrand);
}
