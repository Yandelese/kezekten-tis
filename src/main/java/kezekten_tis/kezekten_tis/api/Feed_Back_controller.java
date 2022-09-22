package kezekten_tis.kezekten_tis.api;
import kezekten_tis.kezekten_tis.Services.EstablishmentService;
import kezekten_tis.kezekten_tis.Services.FeedBackService;
import kezekten_tis.kezekten_tis.Services.UserService;
import kezekten_tis.kezekten_tis.models.Establishment;
import kezekten_tis.kezekten_tis.models.FeedBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value = "/feedback")

public class Feed_Back_controller {

    @Autowired
    FeedBackService feedBackService;
    @Autowired
    EstablishmentService establishmentService;
    @Autowired
    UserService userService;

    @PostMapping ()
    public List<FeedBack> addfeedback (@RequestParam(name = "feedback") String feedback,
                                       @RequestParam(name = "establishment_id") Long establishment_id) {
        System.out.println(feedback);
        System.out.println(establishment_id);
        FeedBack feedBack = new FeedBack();
        feedBack.setContent(feedback);
        feedBack.setEstablishment(establishmentService.getestablishmentbyid(establishment_id));
        feedBack.setAuthor(userService.getcurrentuser());
        feedBackService.addfeedback(feedBack);
        return feedBackService.allfeedback();
    }


    @GetMapping(value = {"/allfeedbacks"})
    public List<FeedBack> feedback(@RequestParam(name = "establishment_id")Long establishmentid){
        System.out.println(establishmentid);
        Establishment establishment=establishmentService.getestablishmentbyid(establishmentid);
        System.out.println(feedBackService.getFeedBackByEstablishment(establishment));
        return feedBackService.getFeedBackByEstablishment(establishment);
    }

    @PostMapping(value = "/deletefeedback")
    public Establishment deletefeedback (@RequestParam(name = "feedbackid") Long feedbackid){
    FeedBack feedBack=feedBackService.getfeedbackbyid(feedbackid);
    Long id=feedBack.getEstablishment().getId();
    feedBackService.deletefeedbackById(feedbackid);
    return establishmentService.getestablishmentbyid(id);
    }
}

