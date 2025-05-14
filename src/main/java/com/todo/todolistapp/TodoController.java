package com.todo.todolistapp;

import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Controller class for the To-Do List application.
 * Handles user interaction with the GUI and communicates with the TaskManager.
 * Author Guillermo Angel
 * Date 2025-05-13
 */
public class TodoController {

    @FXML private TextField taskInput;
    @FXML private ListView<String> taskList;
    @FXML private Button addButton, editButton, removeButton;

    private TaskManager manager = new TaskManager();

    @FXML
    private void initialize() {
        refreshList();

        addButton.setOnAction(e -> {
            try {
                String task = taskInput.getText();
                manager.addTask(task);
                taskInput.clear();
                refreshList();
            } catch (IllegalArgumentException ex) {
                showAlert("Input Error", ex.getMessage());
            }
        });

        removeButton.setOnAction(e -> {
            int index = taskList.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                manager.removeTask(index);
                refreshList();
            } else {
                showAlert("Selection Error", "Please select a task to remove.");
            }
        });

        editButton.setOnAction(e -> {
            String newText = taskInput.getText();
            int index = taskList.getSelectionModel().getSelectedIndex();
            try {
                if (index >= 0) {
                    manager.editTask(index, newText);
                    taskInput.clear();
                    refreshList();
                } else {
                    showAlert("Selection Error", "Please select a task to edit.");
                }
            } catch (IllegalArgumentException ex) {
                showAlert("Input Error", ex.getMessage());
            }
        });
    }

    private void refreshList() {
        taskList.getItems().setAll(manager.getTasks());
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
