package kezekten_tis.kezekten_tis.models;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table
public class Services {
                    @Id
                    @GeneratedValue(strategy = GenerationType.IDENTITY)
                    @Column(name = "id")
                    Long id;

                    @Column(name = "name")
                    String name;

                    @ManyToMany(fetch = FetchType.EAGER)
                    List<Establishment> establishmentList;
}
