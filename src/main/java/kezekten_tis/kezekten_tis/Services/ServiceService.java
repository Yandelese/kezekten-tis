package kezekten_tis.kezekten_tis.Services;
import kezekten_tis.kezekten_tis.models.Establishment;
import kezekten_tis.kezekten_tis.models.Services;
import java.util.List;

public interface ServiceService {


    List<Services> getallservices();
    Services get_service_by_id(Long id);
    List<Services>getallservicesbykeyword(String keyword);
    void addnewservice(Services services);
    Services getservicebyestablishment(Establishment establishment);
    void deleteservicebyid(Long serviceid);



}
