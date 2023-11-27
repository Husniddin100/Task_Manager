package com.company;

import java.time.LocalDateTime;

public class Task {
    private int id;
    private String title;
    private String content;
    private TaskStatus taskStatus;
    private String created_date;

    public Task(int id, String title, String content, TaskStatus taskStatus, String created_date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.taskStatus = taskStatus;
        this.created_date = created_date;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", taskStatus=" + taskStatus +
                ", created_date='" + created_date + '\'' +
                '}';
    }
}
