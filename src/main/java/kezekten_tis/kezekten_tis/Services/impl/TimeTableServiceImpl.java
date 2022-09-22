package kezekten_tis.kezekten_tis.Services.impl;

import kezekten_tis.kezekten_tis.Services.TimeTableService;
import kezekten_tis.kezekten_tis.models.TimeTable;
import kezekten_tis.kezekten_tis.repositories.TimeTableRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class TimeTableServiceImpl implements TimeTableService {

    private final TimeTableRepositories timetablerepositories;


    @Override
    public TimeTable gettablebyid(Long id) {
        return timetablerepositories.findById(id).orElseThrow();
    }

    @Override
    public List<TimeTable> gettablebyestablishmentid(Long id) {
        return timetablerepositories.findAllByEstablishmentId(id);
    }

    @Override
    public void changestatus(TimeTable timeTable) {
        timetablerepositories.save(timeTable);
    }

    @Override
    public void savetimetable(TimeTable timeTable) {
        timetablerepositories.save(timeTable);
    }

    @Override
    public void deletebyid(Long timetable_id) {
        timetablerepositories.deleteById(timetable_id);
    }


}
