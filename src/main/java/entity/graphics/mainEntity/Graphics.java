package entity.graphics.mainEntity;

import entity.computer.Computer;
import entity.graphics.GraphicsChip;
import entity.graphics.Purpose;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@ToString
public class Graphics {
    @Id
    @Getter
    @GeneratedValue
    private Long id;
    @Setter
    @Getter
    private String img;
    @OneToOne
    @Getter
    @Setter
    @ToString.Exclude
    private GraphicsChip graphicsChip;
    @Getter
    @Setter
    private float price;
    @Getter
    @Setter
    @ManyToOne
    private Purpose purpose;
    @Getter
    @Setter
    @OneToMany(mappedBy = "graphics")
    private Set<Computer> computers;
}
