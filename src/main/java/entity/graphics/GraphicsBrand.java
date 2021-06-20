package entity.graphics;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@NoArgsConstructor
@ToString
public class GraphicsBrand {
    @Id
    @GeneratedValue
    @Getter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String country;
    @ManyToMany
    private Set<GraphicsChip> graphicsChips;
}
