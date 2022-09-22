package kezekten_tis.kezekten_tis.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "establishment")
@Data

public class Establishment {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Column(name = "id")
            Long id;

            @Column (name = "name")
            String name;

            @Column (name = "adress")
            String adress;

            @Column (name = "telephone")
            String telephone;



}
