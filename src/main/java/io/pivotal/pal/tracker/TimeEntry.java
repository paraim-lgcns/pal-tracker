package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {

    private final long projectId;
    private final long userId;
    private final LocalDate date;
    private final int hours;
    private final long timeEntryId;

    @Override
    public String toString() {
        return "TimeEntry{" +
                "projectId=" + projectId +
                ", userId=" + userId +
                ", date=" + date +
                ", hours=" + hours +
                ", timeEntryId=" + timeEntryId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return projectId == timeEntry.projectId &&
                userId == timeEntry.userId &&
                hours == timeEntry.hours &&
                timeEntryId == timeEntry.timeEntryId &&
                Objects.equals(date, timeEntry.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId, userId, date, hours, timeEntryId);
    }

    public TimeEntry() {
        projectId = 0;
        userId = 0;
        hours = 0;
        timeEntryId = 0;
        date = null;
    }

    public long getProjectId() {
        return projectId;
    }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }

    public long getTimeEntryId() {
        return timeEntryId;
    }

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {

        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
        timeEntryId = 0;
    }

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate date, int hours) {
        this.timeEntryId = timeEntryId;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }


    public long getId() {
        return timeEntryId;
    }
}
