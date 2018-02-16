package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Observable;

public class DataSource {
    public static ObservableList<StudentRecord> getAllStudents() {
        ObservableList<StudentRecord> records = FXCollections.observableArrayList();

        records.add(new StudentRecord(100000000, "John", "Doe"));
        records.add(new StudentRecord(100000001, "Bob", "Smith"));

        return records;
    }
}

