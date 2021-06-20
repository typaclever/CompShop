package entity.graphics;

import entity.graphics.mainEntity.Graphics;
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
public class Purpose {
    @Id
    @Getter
    @GeneratedValue
    private Long id;
    @Getter
    @Setter
    private String name;
    @OneToMany(mappedBy = "purpose")
    private Set<Graphics> graphics;
}
