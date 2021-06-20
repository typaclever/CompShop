package entity.operationSystem.mainEntity;

import entity.computer.Computer;
import entity.operationSystem.OSBrand;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
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
    private OSBrand brand;
    @ManyToMany
    private Set<Computer> computers;
}
