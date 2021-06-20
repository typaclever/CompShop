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
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@ToString
@NoArgsConstructor
public class ProcessorBrand {
    @Id
    @Getter
    @GeneratedValue
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String country;
    @Getter
    @Setter
    @ToString.Exclude
    @OneToMany(mappedBy = "processorBrand", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private Set<ProcessorFamily> families;
}
