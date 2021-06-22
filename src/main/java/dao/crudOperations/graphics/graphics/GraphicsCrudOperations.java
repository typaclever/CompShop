package dao.crudOperations.graphics.graphics;

import entity.graphics.mainEntity.Graphics;

import java.util.List;
import java.util.Set;

public interface GraphicsCrudOperations {
    Graphics getGraphicsById(Long id);

    void deleteGraphics(Long id);

    void saveGraphics(Graphics graphics);

    List<Graphics> getAllGraphics();

    void updateGraphics(Graphics graphics);
}
