package kezekten_tis.kezekten_tis.repositories;
import kezekten_tis.kezekten_tis.models.Establishment;
import kezekten_tis.kezekten_tis.models.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TimeTableRepositories extends JpaRepository<TimeTable,Long> {

    List<TimeTable> findAllByEstablishmentId(Long id);

}
