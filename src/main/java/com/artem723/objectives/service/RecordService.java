package com.artem723.objectives.service;

import com.artem723.objectives.model.Record;
import com.artem723.objectives.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.Collection;

public interface RecordService {
    Record get(int id, int objectiveId, int userId) throws NotFoundException;

    void delete(int id, int objectiveId, int userId) throws NotFoundException;

    Collection<Record> getBetweenDates(LocalDate startDate, LocalDate endDate, int objectiveId, int userId);

    Collection<Record> getAll(int objectiveId, int userId);

    Record update(Record record, int objectiveId, int userId) throws NotFoundException;

    Record save(Record record, int objectiveId, int userId);
}
