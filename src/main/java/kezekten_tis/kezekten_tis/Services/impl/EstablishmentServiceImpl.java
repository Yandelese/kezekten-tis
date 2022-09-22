package kezekten_tis.kezekten_tis.Services.impl;
import kezekten_tis.kezekten_tis.Services.EstablishmentService;
import kezekten_tis.kezekten_tis.models.Establishment;
import kezekten_tis.kezekten_tis.repositories.EstablishmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class EstablishmentServiceImpl implements EstablishmentService {

    private final EstablishmentRepository establishmentRepository;


    @Override
    public Establishment getestablishmentbyid(Long establishmentid) {
        return establishmentRepository.findById(establishmentid).orElseThrow();
    }

    @Override
    public void savenewestablishment(Establishment establishment) {
        establishmentRepository.save(establishment);
    }

    @Override
    public void deleteestablishmentbyid(Long establishmentid) {
        establishmentRepository.deleteById(establishmentid);
    }

    @Override
    public List<Establishment> getallestablishmentlist() {
        return establishmentRepository.findAll();
    }

    @Override
    public void deleteEstablishmentsByList(List<Establishment> establishments) {
        establishmentRepository.deleteAll(establishments);
    }


}
