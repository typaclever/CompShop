package entity.graphics;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@NoArgsConstructor
@ToString
public class GPUManufacturer {
    @Id
    @GeneratedValue
    @Getter
    private Long id;
    @Setter
    @Getter
    private String name;
    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "gpuManufacturer")
    @Getter
    @Setter
    @ToString.Exclude
    private Set<GraphicsFamily> graphicsFamilies;
}
