package com.artem723.objectives.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "records")
public class Record extends BaseEntity{

    @NotEmpty
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @NotEmpty
    @Column(name = "done", nullable = false)
    private boolean done;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objective_id", nullable = false)
    private Objective objective;

    public Record(){}

    public Record(Integer id, LocalDate date, boolean done) {
        super(id);
        this.date = date;
        this.done = done;
    }

    public Record(Record r) {
        this(r.getId(), r.getDate(), r.isDone());
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                "date=" + date +
                ", done=" + done +
                ", objective=" + objective +
                "} ";
    }
}
