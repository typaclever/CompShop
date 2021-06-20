package entity.graphics;

import entity.graphics.mainEntity.Graphics;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@ToString
@Entity
public class GraphicsChip {
    @Id
    @Getter
    @GeneratedValue
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int memorySize;
    @Getter
    @Setter
    private int bitness;
    @Getter
    @Setter
    private String memoryType;
    @Getter
    @Setter
    @ToString.Exclude
    @ManyToOne
    private GraphicsFamily graphicsFamily;
    @ManyToMany
    @Getter
    @Setter
    @ToString.Exclude
    private Set<GraphicsBrand> graphicsBrands;
    @Getter
    @Setter
    @OneToOne(mappedBy = "graphicsChip", cascade = {CascadeType.REMOVE})
    private Graphics graphics;
}
