package kotlarchik.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "cities")
public class EntityCities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "rate_day", nullable = false)
    private String rateDay;

    @Column(name = "rate_night", nullable = false)
    private String rateNight;

    @Column(name = "image_path", nullable = false)
    private String imagePath;

    // relations
    @OneToMany(mappedBy = "entityCities", fetch = FetchType.EAGER)
    private Set<EntityAbonent> entityAbonentSet;

    @Override
    public String toString() {
        return "EntityCities{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rateDay='" + rateDay + '\'' +
                ", rateNight='" + rateNight + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
