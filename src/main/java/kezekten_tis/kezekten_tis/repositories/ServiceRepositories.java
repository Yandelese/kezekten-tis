package kezekten_tis.kezekten_tis.repositories;

import kezekten_tis.kezekten_tis.models.Establishment;
import kezekten_tis.kezekten_tis.models.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ServiceRepositories extends JpaRepository<Services,Long> {

    List<Services> findByNameIsContaining(String keyword);
    Services findAllByEstablishmentList(Establishment establishment);



}
