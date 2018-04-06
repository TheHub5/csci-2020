import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.*;
import java.util.stream.Collectors.*;

class Lab07count {
	public static void main (String[] args) throws IOException {
		String infile = "weatherwarnings-2015.csv";
		String delimiter = ",";

		//opening file
		BufferedReader br = new BufferedReader(
				new FileReader(infile));
		// convert bufferedreader to list of Strings
		Map<String, Long> lineList = br.lines().map(Object::toString)
				.collect(Collectors.groupingBy(s ->s.split(delimiter)[5], 
																				Collectors.counting()));
		
		br.close(); // Dont forget to close the stream

		// iterate through the lines in the list
		for(Map.Entry<String, Long> e : lineList.entrySet()) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}
	}
}
