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
@Table(name = "abonent")
public class EntityAbonent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "phone", nullable = false)
    private int phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "inn", nullable = false)
    private int inn;

    // relations
    @ManyToOne
    @JoinColumn(name = "cities_id")
    private EntityCities entityCities;

    @ManyToMany
    @JoinTable(name = "abonent_has_phonecall",
    joinColumns = @JoinColumn(name = "phonecall_id"),
    inverseJoinColumns = @JoinColumn(name = "abonent_id"))
    private Set<EntityPhoneCall> entityPhoneCallSet;

    @Override
    public String toString() {
        return "EntityAbonent{" +
                "id=" + id +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", inn=" + inn +
                '}';
    }
}
