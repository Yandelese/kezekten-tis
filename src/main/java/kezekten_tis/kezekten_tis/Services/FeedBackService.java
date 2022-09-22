package kezekten_tis.kezekten_tis.Services;
import kezekten_tis.kezekten_tis.models.Establishment;
import kezekten_tis.kezekten_tis.models.FeedBack;


import java.util.List;

public interface FeedBackService {

    List<FeedBack> getallfeedback(Establishment establishment );
    List<FeedBack> getFeedBackByEstablishment(Establishment establishment);
    void addfeedback(FeedBack feedBack);
    List<FeedBack>allfeedback();
    void deletefeedbackById(Long feedbackid);
    FeedBack getfeedbackbyid(Long feedbackid);


    }
