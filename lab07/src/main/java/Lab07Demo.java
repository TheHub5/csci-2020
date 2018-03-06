import java.io.*;
import java.util.List;
import java.util.stream.*;
import java.util.stream.Collectors.*;

class Lab07Demo {
	public static void main(String[] args) throws IOException {
		String inFile =  "weatherwarnings-2015.csv";
		String delimiter = ",";

		BufferedReader br = new BufferedReader(
												new FileReader(inFile));

		List<String> lineList = br.lines().map(Object::toString)
																			.collect(Collectors.toList());
		br.close();

		for(String line : lineList) {
			String[] data = line.split(delimiter);
			System.out.println(String.join(" | ", data));
		}
		
	}
}
