package com.todo.todolistapp;

import java.util.ArrayList;

/**
 * Description Handles the logic for managing tasks using an ArrayList.
 * Author Guillermo Angel
 * Date 2025-05-13
 */
public class TaskManager {
    private ArrayList<String> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public ArrayList<String> getTasks() {
        return tasks;
    }

    public void addTask(String task) {
        if (task == null || task.trim().isEmpty()) {
            throw new IllegalArgumentException("Task cannot be empty");
        }
        tasks.add(task);
    }

    public void removeTask(int index) {
        tasks.remove(index);
    }

    public void editTask(int index, String newTask) {
        if (newTask == null || newTask.trim().isEmpty()) {
            throw new IllegalArgumentException("Task cannot be empty");
        }
        tasks.set(index, newTask);
    }
}
