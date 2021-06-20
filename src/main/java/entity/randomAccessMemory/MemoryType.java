package entity.randomAccessMemory;

import entity.randomAccessMemory.mainEntity.RandomAccessMemory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@NoArgsConstructor
@ToString
public class MemoryType {
    @Id
    @Getter
    @GeneratedValue
    private Long id;
    @Getter
    @Setter
    private String name;
    @OneToMany(mappedBy = "memoryType")
    @Getter
    @Setter
    @ToString.Exclude
    private Set<RandomAccessMemory> randomAccessMemories;
}
