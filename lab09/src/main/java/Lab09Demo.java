import com.google.gson.*;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;
import java.util.Iterator;
import java.util.Scanner;

class Lab09Demo {
	public static void main (String[] args) throws IOException {
		URL apiURL = new URL("https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=GOOG&apikey=V3TYFURMZMBL59ZN");
		String apiOut = "";
		JsonObject document = null;
		
		try {
			URLConnection apiConn = apiURL.openConnection();
			Scanner connScan =  new Scanner(apiConn.getInputStream());
			while (connScan.hasNextLine()) {
				apiOut += connScan.nextLine();
			}
			connScan.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


		try {
			JsonParser parser = new JsonParser();
			document = parser.parse(apiOut).getAsJsonObject();
		} catch (JsonParseException e) {
			e.printStackTrace();
		}

		if (document!=null) {

			JsonObject series = document.get("Time Series (Daily)").getAsJsonObject();
			Set<String> dates = series.keySet();

			JsonObject metaData = document.get("Meta Data").getAsJsonObject();
			String info = metaData.get("1. Information").getAsString();
			String symbol = metaData.get("2. Symbol").getAsString();

			System.out.println(info + " for " + symbol + "\n\nClosing Prices:");

			for (String date: dates) {
				JsonObject dateData = series.get(date).getAsJsonObject();
				float closingPrice = dateData.get("4. close").getAsFloat();
				System.out.printf("\t%s : %.2f \n", date, closingPrice);


			}
		}
		
	}
}
