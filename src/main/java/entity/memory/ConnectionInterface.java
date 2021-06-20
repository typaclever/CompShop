package entity.memory;


import entity.memory.mainEntity.Memory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString
@NoArgsConstructor
public class ConnectionInterface {
    @Id
    @Getter
    @GeneratedValue
    private Long id;
    @Getter
    @Setter
    private String name;
    @OneToMany(mappedBy = "connectionInterface", fetch = FetchType.LAZY)
    private List<Memory> memories;
}
