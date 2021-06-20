package entity.processor;

import entity.processor.mainEntity.Processor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Entity
@NoArgsConstructor
public class Model {
    @Id
    @Getter
    @GeneratedValue
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int coresCount;
    @Getter
    @Setter
    private float maxFrequency;
    @Getter
    @Setter
    private float baseFrequency;
    @Getter
    @Setter
    private int cache;
    @ToString.Exclude
    @Getter
    @Setter
    @OneToOne(mappedBy = "model", cascade = CascadeType.REMOVE)
    private Processor processor;
    @Getter
    @Setter
    @ToString.Exclude
    @ManyToOne
    private Series series;
}
