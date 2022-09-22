package kezekten_tis.kezekten_tis.Services;
import kezekten_tis.kezekten_tis.models.Establishment;

import java.util.List;


public interface EstablishmentService {

    Establishment getestablishmentbyid(Long id);
    void savenewestablishment(Establishment establishment);
    void deleteestablishmentbyid(Long establishmentid);
    List<Establishment>getallestablishmentlist();
    void deleteEstablishmentsByList(List<Establishment> establishments);


    }
