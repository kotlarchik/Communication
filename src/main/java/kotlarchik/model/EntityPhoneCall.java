package kotlarchik.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "phonecall")
public class EntityPhoneCall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "minutes", nullable = false)
    private int minutes;

    //relations
    @ManyToMany
    @JoinTable(name = "abonent_has_phonecall")
    private Set<EntityAbonent> entityAbonentSet;

    @Override
    public String toString() {
        return "EntityPhoneCall{" +
                "id=" + id +
                ", date=" + date +
                ", minutes=" + minutes +
                '}';
    }
}
