package com.artem723.objectives.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "objectives")
public class Objective extends NamedEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Objective(){}

    public Objective(Integer id, String name) {
        super(id, name);
    }

    public Objective(Objective o) {
        this(o.getId(), o.getName());
    }

    @Override
    public String toString() {
        return "Objective{" +
                "id=" + id +
                "name='" + name + '\'' +
                "} ";
    }
}
