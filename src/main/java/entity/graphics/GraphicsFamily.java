package entity.graphics;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@ToString
@NoArgsConstructor
@Entity
public class GraphicsFamily {
    @Id
    @Getter
    @GeneratedValue
    private Long id;
    @Getter
    @Setter
    private String name;
    @OneToMany
    @ToString.Exclude
    @Getter
    @Setter
    private Set<GraphicsChip> graphicsChips;
    @ManyToOne
    @Getter
    @Setter
    private GPUManufacturer gpuManufacturer;
}
