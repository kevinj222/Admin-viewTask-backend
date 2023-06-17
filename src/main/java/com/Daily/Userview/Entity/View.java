package com.Daily.Userview.Entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "UserTasks")
public class View
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String name;
    private String tasks;
    private String status;
    private String deadline;
    @Column(length = 2000)
    private String comments;

    @Override
    public String toString()
    {
        return "View{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", tasks='" + tasks + '\'' +
                ", status='" + status + '\'' +
                ", deadline='" + deadline + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

    public View(int id, String username, String name, String tasks, String status, String deadline, String comments) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.tasks = tasks;
        this.status = status;
        this.deadline = deadline;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTasks()
    {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public View()
    {

    }
}
