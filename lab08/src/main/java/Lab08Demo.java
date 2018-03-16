package Lab08;

import java.io.*;
import java.util.List;
import java.util.Iterator;
import javafx.collections.*;

class Lab08Demo {
	public static void main (String[] args) {
		String outFile = "students.csv";
		String delimter = ",";

		ObservableList<StudentRecord> students =
							FXCollections.observableArrayList();

		students.add(new StudentRecord(100000001, "Jane", "Doe"));
		students.add(new StudentRecord(100000002, "John", "Doe"));

		Iterator<StudentRecord> itr = students.iterator();

		try(PrintWriter out = new PrintWriter(outFile)) {
			while  (itr.hasNext()) {
				StudentRecord s = itr.next();
				out.print(s.getSid() + delimter);
				out.print(s.getFname() + delimter);
				out.println(s.getLname());
			}
		} catch (IOException e) {
			System.out.println("Something went wrong while writing to file");
			e.printStackTrace();
		}
	}
}
