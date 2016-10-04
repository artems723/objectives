package com.artem723.objectives.repository;

import com.artem723.objectives.model.Record;

import java.time.LocalDate;
import java.util.Collection;

public interface RecordRepository {
    // null if updated record do not belong to objectiveId and userId
    Record save(Record record, int objectiveId, int userId);

    // false if record do not belong to objectiveId and userId
    boolean delete(int id, int objectiveId, int userId);

    // null if record do not belong to objectiveId and userId
    Record get(int id, int objectiveId, int userId);

    // ORDERED date
    Collection<Record> getAll(int objectiveId, int userId);

    // ORDERED date
    Collection<Record> getBetween(LocalDate startDate, LocalDate endDate, int objectiveId, int userId);
}
