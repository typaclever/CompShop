package entity.computer;

import entity.graphics.mainEntity.Graphics;
import entity.memory.mainEntity.Memory;
import entity.operationSystem.mainEntity.OperationSystem;
import entity.processor.mainEntity.Processor;
import entity.randomAccessMemory.mainEntity.RandomAccessMemory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

@Entity
@NoArgsConstructor
@ToString
public abstract class Computer {
    @Id
    @GeneratedValue
    @Getter
    private Long id;
    @Getter
    @Setter
    private String img;
    @Getter
    @Setter
    @ManyToOne
    private Processor processor;
    @ManyToOne
    @Getter
    @Setter
    private Graphics graphics;
    @ManyToOne
    @Setter
    @Getter
    private Memory memory;
    @ManyToOne
    @Getter
    @Setter
    private RandomAccessMemory randomAccessMemory;
    @ManyToMany
    private Set<OperationSystem> operationSystems;
}
