package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class Main extends Application {
    private TableView<StudentRecord> students;


    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Lab 05");

        TableColumn<StudentRecord, Integer> idCol = new TableColumn<>("SID");
        idCol.setPrefWidth(100);
        idCol.setCellValueFactory(new PropertyValueFactory<>("sid"));

        TableColumn<StudentRecord, String > fCol = new TableColumn<>("First Name");
        fCol.setPrefWidth(200);
        fCol.setCellValueFactory(new PropertyValueFactory<>("fname"));


        TableColumn<StudentRecord, String > lCol = new TableColumn<>("Last Name");
        lCol.setPrefWidth(200);
        lCol.setCellValueFactory(new PropertyValueFactory<>("lname"));

        students = new TableView<>();
        students.getColumns().add(idCol);
        students.getColumns().add(fCol);
        students.getColumns().add(lCol);


        primaryStage.setScene(new Scene(students, 300, 275));
        primaryStage.show();

        students.setItems(DataSource.getAllStudents());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
