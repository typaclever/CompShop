package entity.randomAccessMemory.mainEntity;

import entity.computer.Computer;
import entity.randomAccessMemory.MemoryType;
import entity.randomAccessMemory.RAMBrand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity

@ToString
public class RandomAccessMemory {
    @Id
    @Getter
    @GeneratedValue
    private Long id;
    @Setter
    @Getter
    private String img;
    @Getter
    @Setter
    private int size;
    @Getter
    @Setter
    private int memoryFrequency;
    @Getter
    @Setter
    private int numberOfPlanks;
    @Getter
    @Setter
    @ManyToOne
    @ToString.Exclude
    private MemoryType memoryType;
    @ManyToOne
    @Getter
    @Setter
    @ToString.Exclude
    private RAMBrand brand;
    @OneToMany(mappedBy = "randomAccessMemory")
    @Setter
    @Getter
    @ToString.Exclude
    private Set<Computer> computers;
}
