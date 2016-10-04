package com.artem723.objectives.repository;

import com.artem723.objectives.model.Objective;

import java.util.Collection;

public interface ObjectiveRepository {
    // null if updated objective do not belong to userId
    Objective save(Objective objective, int userId);

    // false if objective do not belong to userId
    boolean delete(int id, int userId);

    // null if objective do not belong to userId
    Objective get(int id, int userId);

    // ORDERED name
    Collection<Objective> getAll(int userId);
}
