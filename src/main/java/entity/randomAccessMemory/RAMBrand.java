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
@ToString
@NoArgsConstructor
public class RAMBrand {
    @Id
    @GeneratedValue
    @Getter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String country;
    @OneToMany(mappedBy = "brand")
    @Getter
    @Setter
    @ToString.Exclude
    private Set<RandomAccessMemory> rams;
}
