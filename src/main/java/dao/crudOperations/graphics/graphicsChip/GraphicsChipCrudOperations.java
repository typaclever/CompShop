package dao.crudOperations.graphics.graphicsChip;

import entity.graphics.GraphicsBrand;
import entity.graphics.GraphicsChip;

import java.util.Set;

public interface GraphicsChipCrudOperations {
    GraphicsChip getGraphicsChipById(Long id);
    void deleteGraphicsChip(Long id);
    void saveGraphicsChip(GraphicsChip graphicsChip);
    Set<GraphicsChip> getAllGraphicsChips();
    void updateGraphicsChip(GraphicsChip graphicsChip);
}
