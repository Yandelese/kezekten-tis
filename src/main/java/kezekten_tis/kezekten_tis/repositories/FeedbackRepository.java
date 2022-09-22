package kezekten_tis.kezekten_tis.repositories;
import kezekten_tis.kezekten_tis.models.FeedBack;
import kezekten_tis.kezekten_tis.models.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface FeedbackRepository extends JpaRepository<FeedBack, Long> {
    List<FeedBack> findAllByEstablishment(Establishment establishment);

}
