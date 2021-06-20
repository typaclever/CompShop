package entity.operationSystem;

import entity.operationSystem.mainEntity.OperationSystem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@ToString
@NoArgsConstructor
public class OSBrand {
    @Id
    @Getter
    @GeneratedValue
    private Long id;
    @Setter
    @Getter
    private String name;
    @OneToMany(mappedBy = "brand", cascade = {CascadeType.REMOVE})
    private Set<OperationSystem> operationSystems;
}
