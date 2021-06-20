package entity.memory;

import entity.memory.mainEntity.Memory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@ToString
@NoArgsConstructor
public class SSD extends Memory {
    @Getter
    @Setter
    private int readingSpeed;
    @Getter
    @Setter
    private int recordingSpeed;
    @ManyToOne
    @Getter
    @Setter
    @ToString.Exclude
    private MemoryCellType memoryCellType;
}
