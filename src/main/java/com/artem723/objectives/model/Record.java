package com.artem723.objectives.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "records")
public class Record extends BaseEntity{

    @NotEmpty
    @Column(name = "date", nullable = false, unique = true)
    private LocalDate date;

    @NotEmpty
    @Column(name = "done", nullable = false)
    private Boolean done;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objective_id", nullable = false)
    private Objective objective;

    public Record(){}

    public Record(Integer id, LocalDate date, Boolean done) {
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

    public Boolean isDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Record{" +
                "date=" + date +
                ", done=" + done +
                ", objective=" + objective +
                "} " + super.toString();
    }
}
