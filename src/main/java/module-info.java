module com.todo.todolistapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.todo.todolistapp to javafx.fxml;
    exports com.todo.todolistapp;
}