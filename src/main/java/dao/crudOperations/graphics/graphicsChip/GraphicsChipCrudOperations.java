package dao.crudOperations.graphics.graphicsChip;

import entity.graphics.GraphicsBrand;
import entity.graphics.GraphicsChip;

import java.util.List;
import java.util.Set;

public interface GraphicsChipCrudOperations {
    GraphicsChip getGraphicsChipById(Long id);

    void deleteGraphicsChip(Long id);

    void saveGraphicsChip(GraphicsChip graphicsChip);

    List<GraphicsChip> getAllGraphicsChips();

    void updateGraphicsChip(GraphicsChip graphicsChip);
}
