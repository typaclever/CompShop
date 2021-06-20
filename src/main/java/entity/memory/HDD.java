package entity.memory;

import entity.memory.mainEntity.Memory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@ToString
@NoArgsConstructor
public class HDD extends Memory {
    @Getter
    @Setter
    private int spindleSpeed;
    @Getter
    @Setter
    private int bufferVolume;
    @Getter
    @Setter
    private int baudRate;
}
