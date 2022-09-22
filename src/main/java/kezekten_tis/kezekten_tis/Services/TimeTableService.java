package kezekten_tis.kezekten_tis.Services;

import kezekten_tis.kezekten_tis.models.Establishment;
import kezekten_tis.kezekten_tis.models.TimeTable;


import java.util.List;


public interface TimeTableService {

    TimeTable gettablebyid(Long id);
    List<TimeTable> gettablebyestablishmentid(Long id);
    void changestatus(TimeTable timeTable);
    void savetimetable(TimeTable timeTable);
    void deletebyid(Long timetable_id);

}
