package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataSource {
    public static ObservableList<StudentRecord> getAllStudents() {
        ObservableList<StudentRecord> records =  FXCollections.observableArrayList();

        records.add(new StudentRecord(100000000, "John", "Smith"));
        records.add(new StudentRecord(100000001, "Bob", "Smith"));


        return records;
    }
}
