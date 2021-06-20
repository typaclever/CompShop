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
public class FormFactor {
    @Id
    @Getter
    @GeneratedValue
    private Long id;
    @Getter
    @Setter
    @OneToMany(mappedBy = "formFactor", fetch = FetchType.LAZY)
    List<Memory> memories;
}
