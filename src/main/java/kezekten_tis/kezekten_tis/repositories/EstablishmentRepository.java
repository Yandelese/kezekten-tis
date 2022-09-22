package kezekten_tis.kezekten_tis.repositories;
import kezekten_tis.kezekten_tis.models.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;



@Repository
@Transactional
public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {


}
