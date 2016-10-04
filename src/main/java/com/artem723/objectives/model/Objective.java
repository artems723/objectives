package com.artem723.objectives.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "objectives")
public class Objective extends BaseEntity {

    @NotEmpty
    @Column(name = "name", nullable = false, unique = true)
    protected String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Objective(){}

    public Objective(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public Objective(Objective o) {
        this(o.getId(), o.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Objective{" +
                "id=" + id +
                "name='" + name + '\'' +
                "} ";
    }
}
