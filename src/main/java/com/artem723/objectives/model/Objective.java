package com.artem723.objectives.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Map;

@Entity
@Table(name = "objectives")
public class Objective extends BaseEntity {

    @NotEmpty
    @Column(name = "name", nullable = false)
    protected String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @MapKey(name = "data")
    @Column(name = "dones", nullable = false)
    protected Map<LocalDate, Boolean> dones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Objective(){}

    public Objective(Integer id, String name, Map<LocalDate, Boolean> dones) {
        super(id);
        this.name = name;
        this.dones = dones;
    }

    public Objective(Objective o) {
        this(o.getId(), o.getName(), o.getDones());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<LocalDate, Boolean> getDones() {
        return dones;
    }

    public void setDones(Map<LocalDate, Boolean> dones) {
        this.dones = dones;
    }

    @Override
    public String toString() {
        return "Objective{" +
                "id=" + id +
                "name='" + name + '\'' +
                ", dones=" + dones +
                "} ";
    }
}
