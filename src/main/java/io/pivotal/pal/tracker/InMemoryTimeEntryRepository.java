package io.pivotal.pal.tracker;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    Map<Long,TimeEntry> timeEntryMap=new HashMap<>();
    private long id=0L;
    public TimeEntry create(TimeEntry timeEntry) {
        long timeEntryId=++id;
        TimeEntry newTimeEntry=new TimeEntry(timeEntryId, timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
        timeEntryMap.put(timeEntryId,newTimeEntry);
        return newTimeEntry;
    }

    public TimeEntry find(long id) {

        return timeEntryMap.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(timeEntryMap.values());

    }

    public TimeEntry update(long id, TimeEntry timeEntry) {
        //timeEntryMap.put(id, timeEntry)
        TimeEntry timeEntrytoUpdate = timeEntryMap.get(id);
        if(timeEntrytoUpdate!=null) {
            TimeEntry timeEntryUpdated=new TimeEntry(id, timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
            timeEntryMap.replace(id, timeEntryUpdated);
            return timeEntryUpdated;
        }
        else
        {
            return null;
        }

//
    }

    public void delete(long id) {

        timeEntryMap.remove(id);


    }
}
