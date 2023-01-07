module com.example.sankeandladder {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.snakeandladder to javafx.fxml;
    exports com.example.snakeandladder;
}