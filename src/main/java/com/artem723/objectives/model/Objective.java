package com.artem723.objectives.model;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Objective{" +
                "id=" + id +
                "name='" + name + '\'' +
                "} ";
    }
}
