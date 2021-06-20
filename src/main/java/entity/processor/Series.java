package entity.processor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@ToString
@Entity
@NoArgsConstructor
public class Series {
    @Id
    @GeneratedValue
    @Getter
    private Long id;
    @Getter
    @Setter
    private String name;
    @OneToMany(mappedBy = "series", cascade = CascadeType.REMOVE)
    @Getter
    @Setter
    @ToString.Exclude
    private Set<Model> models;
    @ManyToOne
    @ToString.Exclude
    @Getter
    @Setter
    private ProcessorFamily processorFamily;
}
