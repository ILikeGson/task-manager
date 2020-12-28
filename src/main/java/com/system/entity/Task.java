package com.system.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private long id;

    @Column(name = "task_date")
    private String date;

    @Column(name = "task_starttime")
    private String startTime;

    @Column(name = "task_stoptime")
    private String stopTime;

    @Column(name = "task_description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Task(String date, String startTime, String stopTime, String description) {
        this.date = date;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.description = description;
    }
}
