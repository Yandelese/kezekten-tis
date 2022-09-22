package kezekten_tis.kezekten_tis.Services.impl;
import kezekten_tis.kezekten_tis.Services.EstablishmentService;
import kezekten_tis.kezekten_tis.Services.ServiceService;
import kezekten_tis.kezekten_tis.models.Establishment;
import kezekten_tis.kezekten_tis.models.Services;
import kezekten_tis.kezekten_tis.repositories.ServiceRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ServiceServiceImpl implements ServiceService {

private final ServiceRepositories servicerepositories;
private final EstablishmentService establishmentService;
    @Override
    public List<Services> getallservices() {
        List<Services>allservices=servicerepositories.findAll();
        return allservices;
    }

    @Override
    public Services get_service_by_id(Long id) {
        return servicerepositories.findById(id).orElseThrow();
    }

    @Override
    public List<Services> getallservicesbykeyword(String keyword) {
        return servicerepositories.findByNameIsContaining(keyword);
    }

    @Override
    public void addnewservice(Services services) {
        servicerepositories.save(services);
    }

    @Override
    public Services getservicebyestablishment(Establishment establishment) {
        return servicerepositories.findAllByEstablishmentList(establishment);
    }

    @Override
    public void deleteservicebyid(Long serviceid) {
        servicerepositories.deleteById(serviceid);
    }


}

