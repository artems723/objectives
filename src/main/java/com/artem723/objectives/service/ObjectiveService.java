package com.artem723.objectives.service;

import com.artem723.objectives.model.Objective;
import com.artem723.objectives.util.exception.NotFoundException;

import java.util.Collection;

public interface ObjectiveService {
    Objective get(int id, int userId) throws NotFoundException;

    void delete(int id, int userId) throws NotFoundException;

    Collection<Objective> getAll(int userId);

    Objective update(Objective objective, int userId) throws NotFoundException;

    Objective save(Objective objective, int userId);
}
