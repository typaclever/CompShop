package entity.memory.mainEntity;

import entity.computer.Computer;
import entity.memory.ConnectionInterface;
import entity.memory.FormFactor;
import entity.memory.MemoryBrand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@ToString
@Entity
public abstract class Memory {
    @Id
    @Getter
    @GeneratedValue
    private Long id;
    @Getter
    @Setter
    private String img;
    @Getter
    @Setter
    private int size;
    @Getter
    @Setter
    @ManyToOne
    private ConnectionInterface connectionInterface;
    @Getter
    @Setter
    @ManyToOne
    private FormFactor formFactor;
    @ManyToOne
    @Getter
    @Setter
    @ToString.Exclude
    private MemoryBrand brand;
    @Setter
    @Getter
    @ToString.Exclude
    @OneToMany(mappedBy = "memory")
    private Set<Computer> computers;
}
