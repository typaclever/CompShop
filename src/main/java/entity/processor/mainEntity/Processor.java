package entity.processor.mainEntity;

import entity.computer.Computer;
import entity.processor.Model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@ToString
@NoArgsConstructor
@Entity
public class Processor {
    @Id
    @GeneratedValue
    @Getter
    private Long id;
    @Getter
    @Setter
    private String img;
    @OneToOne
    @Getter
    @Setter
    private Model model;
    @Getter
    @Setter
    private float price;
    @OneToMany(mappedBy = "processor")
    private Set<Computer> computers;
}
