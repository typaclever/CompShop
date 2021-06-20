package entity.processor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@ToString
@NoArgsConstructor
public class ProcessorFamily {
    @Id
    @Getter
    @GeneratedValue
    private Long id;
    @Setter
    @Getter
    private String name;
    @Getter
    @Setter
    @OneToMany(
            cascade = {CascadeType.REMOVE},
            fetch = FetchType.LAZY,
            mappedBy = "series"
    )
    @ToString.Exclude
    private Set<Series> seriesList;
    @ManyToOne
    @ToString.Exclude
    @Getter
    @Setter
    private ProcessorBrand processorBrand;
}
