package kezekten_tis.kezekten_tis.Controller;
import kezekten_tis.kezekten_tis.Services.*;
import kezekten_tis.kezekten_tis.Services.TimeTableService;
import kezekten_tis.kezekten_tis.models.*;
import kezekten_tis.kezekten_tis.models.TimeTable;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;



@RequiredArgsConstructor
@Controller
public class HomeController {

    private final ServiceService serviceService;
    private final TimeTableService timeTableService;
    private final FeedBackService feedBackService;
    private final EstablishmentService establishmentService;
    private final UserService userService;


    @GetMapping(value = "/")
    public String index(Model model) {
        return "signup";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/mainpage")
    public String mainpage(Model model) {
        List<Services> allservices = serviceService.getallservices();
        model.addAttribute("allservices", allservices);
        return "mainpage";
    }


    @GetMapping(value = "/registration")
    public String register() {
        return "register";
    }

    @GetMapping(value = "/signup")
    public String signup() {
        return "signup";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/service_details/{id}")
    public String service_details(@PathVariable(name = "id") Long id, Model model) {
        Services services = serviceService.get_service_by_id(id);
        model.addAttribute("certain_service", serviceService.get_service_by_id(id));
        return "servicedetails";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/make_queue/{id}")
    public String make_queue(@PathVariable(name = "id") Long id, Model model) {
        List<TimeTable> timeTableList = timeTableService.gettablebyestablishmentid(id);
        System.out.println(timeTableList);
        model.addAttribute("certaintable", timeTableList);
        return "time_table";
    }

    @GetMapping(value = "/change_status/{tableid}")
    public String changestatus(@PathVariable(name = "tableid") Long tableid) {
        System.out.println(tableid);
        TimeTable timeTable = timeTableService.gettablebyid(tableid);
        timeTable.setStatus(true);
        timeTableService.changestatus(timeTable);
        Long id = timeTable.getEstablishment().getId();
        return "redirect:/make_queue/" + id;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/feedback1/{establishmentid}")
    public String feedback(@PathVariable(name = "establishmentid") Long establishmentid, Model model) {
        model.addAttribute("establishment", establishmentService.getestablishmentbyid(establishmentid));
        model.addAttribute("currentuser", userService.getcurrentuser());
        return "feedback";
    }

    @PostMapping(value = "/search")
    public String search(Model model, @RequestParam("keyword") String keyword) {
        List<Services> servicesList = serviceService.getallservicesbykeyword(keyword);
        model.addAttribute("allservices", servicesList);
        return "mainpage";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/addservice")
    public String addservice() {
        return "addservice";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/addestablishment/{serviceid}")
    public String addservicetodb(@PathVariable(name = "serviceid") Long serviceid, Model model) {
        System.out.println(serviceid);
        model.addAttribute("serviceid", serviceid);
        return "addestablishment";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(value = "/addnewservice")
    public String addnewservice(@RequestParam("newservice") String newservice) {
        Services services = new Services();
        services.setName(newservice);
        serviceService.addnewservice(services);
        return "redirect:/mainpage";
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(value = "/addnewestablishmenttodb")
    public String addnewestablishment1(@RequestParam(name = "name") String name,
                                       @RequestParam(name = "address") String address,
                                       @RequestParam(name = "telephone") String telephone,
                                       @RequestParam(name = "serviceid") Long serviceid, Model model) {

        Establishment establishment = new Establishment();
        establishment.setName(name);
        establishment.setAdress(address);
        establishment.setTelephone(telephone);
        establishmentService.savenewestablishment(establishment);

        Services services = serviceService.get_service_by_id(serviceid);
        List<Establishment> establishmentList = services.getEstablishmentList();
        establishmentList.add(establishment);
        serviceService.addnewservice(services);

        return "redirect:/service_details/" + services.getId();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/addtable/{establishment_id}")
    public String addtable(@PathVariable(name = "establishment_id") Long establishment_id, Model model) {
        model.addAttribute("establishment", establishmentService.getestablishmentbyid(establishment_id));
        return "addtime_table";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(value = "/addtabletodb")
    public String addtabletoEstablishment(@RequestParam(name = "establishment_id") Long establishment_id,
                                          @RequestParam(name = "day") String day,
                                          @RequestParam(name = "time") String time) {

        Establishment establishment = establishmentService.getestablishmentbyid(establishment_id);

        TimeTable timeTable = new TimeTable();
        timeTable.setDay(day);
        timeTable.setTime(time);
        timeTable.setEstablishment(establishment);
        timeTableService.savetimetable(timeTable);

        return "redirect:/make_queue/" + establishment.getId();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/edittable/{table_id}")
    public String edittable(@PathVariable(name = "table_id") Long table_id, Model model) {
        model.addAttribute("time_table", timeTableService.gettablebyid(table_id));
        return "edittime_table";
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(value = "/edit_time_table")
    public String edittable(@RequestParam(name = "certain_table_id") Long certain_table_id,
                            @RequestParam(name = "day") String day,
                            @RequestParam(name = "time") String time) {
        TimeTable table = timeTableService.gettablebyid(certain_table_id);
        table.setDay(day);
        table.setTime(time);
        timeTableService.savetimetable(table);

        return "redirect:/make_queue/" + table.getEstablishment().getId();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/deletetable/{table_id}")
    public String deletetable(@PathVariable(name = "table_id") Long certain_table_id) {
        TimeTable table = timeTableService.gettablebyid(certain_table_id);
        timeTableService.deletebyid(certain_table_id);
        return "redirect:/make_queue/" + table.getEstablishment().getId();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/editestablishment/{establishment_id}")
    public String editservicetodb(@PathVariable(name = "establishment_id") Long establishmentid, Model model) {
        System.out.println(establishmentid);
        Establishment establishment = establishmentService.getestablishmentbyid(establishmentid);
        model.addAttribute("establishment", establishment);
        return "editestablishment";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(value = "/changestablishment")
    public String editestablishment(@RequestParam(name = "name") String name,
                                    @RequestParam(name = "address") String adress,
                                    @RequestParam(name = "telephone") String telephone,
                                    @RequestParam(name = "establishment_id") Long establishment_id) {

        Establishment establishment = establishmentService.getestablishmentbyid(establishment_id);
        establishment.setName(name);
        establishment.setAdress(adress);
        establishment.setTelephone(telephone);
        establishmentService.savenewestablishment(establishment);

        Services services = serviceService.getservicebyestablishment(establishment);
        System.out.println(services.getId());

        return "redirect:/service_details/" + services.getId();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/deleteestablishment/{establishment_id}")
    public String deleteservicefrombd(@PathVariable(name = "establishment_id") Long establishmentid, Model model) {
        List<TimeTable> tableList = timeTableService.gettablebyestablishmentid(establishmentid);
        Services services = new Services();
        if (tableList != null) {
            for (TimeTable table : tableList) {
                timeTableService.deletebyid(table.getId());
            }
            Establishment establishment = establishmentService.getestablishmentbyid(establishmentid);
            services = serviceService.getservicebyestablishment(establishmentService.getestablishmentbyid(establishmentid));
            services.getEstablishmentList().remove(establishment);
            establishmentService.deleteestablishmentbyid(establishmentid);

        } else establishmentService.deleteestablishmentbyid(establishmentid);

        return "redirect:/service_details/" + services.getId();

    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/editservice/{serviceid}")
    public String editservice(@PathVariable(name = "serviceid") Long serviceid, Model model) {
        Services service = serviceService.get_service_by_id(serviceid);
        model.addAttribute("service", service);
        return "editservices";
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping(value = "/changeservice")
    public String changeservice(@RequestParam("new_name_of_service") String newname,
                                @RequestParam("service_id") Long serviceid) {
        Services services = serviceService.get_service_by_id(serviceid);
        services.setName(newname);
        serviceService.addnewservice(services);
        return "redirect:/mainpage";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(value = "/deleteservice/{serviceid}")
    public String deleteservice(@PathVariable(name = "serviceid") Long serviceid, Model model) {
        Services services = serviceService.get_service_by_id(serviceid);///вытягиваем сервис

        List<Establishment> establishmentList = services.getEstablishmentList(); /// из сервиса вытягиваем все заведения

        for (Establishment establishment : establishmentList) { ////пробегаемся по заведениям и удаляем их расписание
            List<TimeTable> tableList = timeTableService.gettablebyestablishmentid(establishment.getId());
            for (TimeTable table : tableList) {
                timeTableService.deletebyid(table.getId());
            }
        }

        for (Establishment establishment : establishmentList) { ////пробегаемся по заведениям и удаляем их отзывы
            List<FeedBack> feedBackList = feedBackService.getFeedBackByEstablishment(establishment);
            for (FeedBack feedBack : feedBackList) {
                feedBackService.deletefeedbackById(feedBack.getId());
            }
        }

        ArrayList<Long>longArrayList=new ArrayList<>();

        List<Establishment> establishmentList1 = services.getEstablishmentList(); ///с сервиса вытянул все его establishmentlist
        for (Establishment est:establishmentList1) {
            Long establishmnet_id=est.getId();
            longArrayList.add(establishmnet_id);
        }
        services.getEstablishmentList().removeAll(establishmentList1);// и удалил его

        for (Long estab_id:longArrayList) {
            establishmentService.deleteestablishmentbyid(estab_id);
        }

        serviceService.deleteservicebyid(serviceid);

        return "redirect:/mainpage";
    }
}
