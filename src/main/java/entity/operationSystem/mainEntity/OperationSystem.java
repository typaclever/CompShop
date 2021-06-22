package entity.operationSystem.mainEntity;

import entity.computer.Computer;
import entity.operationSystem.OSBrand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

@Entity
@ToString
@NoArgsConstructor
public class OperationSystem {
    @Id
    @Getter
    @GeneratedValue
    private Long id;
    @ManyToOne
    @Getter
    @Setter
    private OSBrand brand;
    @Getter
    @Setter
    private String name;
    @ManyToMany
    private Set<Computer> computers;
}
