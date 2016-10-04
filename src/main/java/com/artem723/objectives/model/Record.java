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
}
