package entity.memory;

import entity.memory.mainEntity.Memory;
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
public class MemoryBrand {
    @Id
    @Getter
    @GeneratedValue
    private Long id;
    @Getter
    @Setter
    private String name;
    @ToString.Exclude
    @OneToMany(mappedBy = "brand", cascade = {CascadeType.REMOVE})
    private Set<Memory> memories;
}
