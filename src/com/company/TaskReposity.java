package com.company;

import java.sql.*;
import java.util.LinkedList;
import java.util.Scanner;

import static com.company.TaskStatus.ACTIVE;
import static com.company.TaskStatus.DONE;

public class TaskReposity {
    public void createTask(){
        Scanner scanner=new Scanner(System.in);
        Scanner scanner1=new Scanner(System.in);
        System.out.println("Enter id");
        int id=scanner1.nextInt();
        System.out.println("Enter title");
        String title=scanner.nextLine();
        System.out.println("Enter content");
        String content=scanner.nextLine();
        System.out.println("Enter created date");
        String createdDate=scanner.nextLine();

        Task task1=new Task();
        task1.setId(id);
        task1.setTitle(title);
        task1.setContent(content);
        task1.setTaskStatus(ACTIVE);
        task1.setCreated_date(createdDate);
        try {
            Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db",
            "jdbc_user", "123456");
            Statement statement=connection.createStatement();
            String sql="insert into Task (id,title,content,task_status,created_date)" +
                    "values("+task1.getId()+",'"+task1.getTitle()+"','"+task1.getContent()+"','"+task1.getTaskStatus()+"'," +
                    "'"+task1.getCreated_date()+"')";
            int effectiveRows=statement.executeUpdate(sql);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public LinkedList<Task> ActiveTaskList(){
        LinkedList<Task>taskLinkedList=new LinkedList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db",
                    "jdbc_user", "123456");
            Statement statement = con.createStatement();
            ResultSet rs=statement.executeQuery("select * from Task");
            while (rs.next()){
                Task task=new Task();
                task.setId(rs.getInt("id"));
                task.setTitle(rs.getString("title"));
                task.setContent(rs.getString("content"));
                task.setTaskStatus(TaskStatus.valueOf(rs.getString("task_status")));
                task.setCreated_date(rs.getString("created_date"));
                taskLinkedList.add(task);
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return taskLinkedList;
    }

    public void tasklist(){
        LinkedList<Task>list=ActiveTaskList();
        for (Task task:list) {
            if (task.getTaskStatus() == ACTIVE) {
                System.out.println(task.getId() + " " + task.getTitle() + " " + task.getContent() + " " + task.getTaskStatus() + " "
                        + task.getCreated_date() + " ");
            }
        }
    }

    public void FinishedTaskList(){
        LinkedList<Task>list=ActiveTaskList();
        for (Task task:list) {
            if (task.getTaskStatus() == DONE) {
                System.out.println(task.getId() + " " + task.getTitle() + " " + task.getContent() + " " + task.getTaskStatus() + " "
                        + task.getCreated_date() + " ");
            }
        }
    }
}
