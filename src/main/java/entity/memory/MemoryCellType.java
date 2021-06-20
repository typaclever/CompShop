package entity.memory;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@ToString
@NoArgsConstructor
public class MemoryCellType {
    @Id
    @Getter
    @GeneratedValue
    private Long id;
    @Getter
    @Setter
    private String name;
    @ToString.Exclude
    @OneToMany(mappedBy = "memoryCellType")
    private List<SSD> ssds;
}
