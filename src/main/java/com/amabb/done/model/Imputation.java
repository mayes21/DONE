package com.amabb.done.model;

import com.amabb.done.utils.csv.CSVColumnHeader;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * Created by amayas on 25/09/16.
 */

@Entity
@Table(name="imputation")
public class Imputation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imput")
    private int id;

    @NotNull
    @Column(name = "time_spent")
    @CSVColumnHeader(name = "Temps passé")
    private double timeSpent;

    @NotEmpty
    @Column(name = "task")
    @CSVColumnHeader(name = "Tâche")
    private String task;

    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "date", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @CSVColumnHeader(name = "Date")
    private LocalDate date;

    @Column(name = "status")
    @CSVColumnHeader(name = "Statut")
    private String status;

    @NotEmpty
    @Column(name = "project")
    @CSVColumnHeader(name = "Projet")
    private String project;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(double timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Imputation [" + timeSpent + " - " + project + " - " + task + " - " + date + " - " + status;
    }
}
