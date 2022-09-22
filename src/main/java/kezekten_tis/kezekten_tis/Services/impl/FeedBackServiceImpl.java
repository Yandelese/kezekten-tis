package kezekten_tis.kezekten_tis.Services.impl;
import kezekten_tis.kezekten_tis.Services.FeedBackService;
import kezekten_tis.kezekten_tis.models.Establishment;
import kezekten_tis.kezekten_tis.models.FeedBack;
import kezekten_tis.kezekten_tis.repositories.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class FeedBackServiceImpl implements FeedBackService{

    private final FeedbackRepository feedbackRepository;


    @Override
    public List<FeedBack> getallfeedback(Establishment establishment) {
        return feedbackRepository.findAllByEstablishment(establishment);
    }

    @Override
    public List<FeedBack> getFeedBackByEstablishment(Establishment establishment) {
        return feedbackRepository.findAllByEstablishment(establishment);
    }

    @Override
    public void addfeedback(FeedBack feedBack) {
        feedbackRepository.save(feedBack);
    }

    @Override
    public List<FeedBack> allfeedback() {
        return feedbackRepository.findAll();
    }

    @Override
    public void deletefeedbackById(Long feedbackid) {
        feedbackRepository.deleteById(feedbackid);
    }

    @Override
    public FeedBack getfeedbackbyid(Long feedbackid) {
        return feedbackRepository.findById(feedbackid).orElseThrow();
    }
}
