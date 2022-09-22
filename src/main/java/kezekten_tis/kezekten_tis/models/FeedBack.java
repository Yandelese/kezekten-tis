package kezekten_tis.kezekten_tis.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "feedback")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    private Establishment establishment;

    @ManyToOne(fetch = FetchType.EAGER)
    private User author;

    private Date postdate;

    @PrePersist
    private void prePersist(){
        postdate = new Date();
    }
}