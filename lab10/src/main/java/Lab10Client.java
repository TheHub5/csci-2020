import java.io.*;
import java.net.*;

public class Lab10Client {
		public static String SERVER_ADDRESS = "localhost";
		public static int SERVER_PORT= 49000;

		public static void main (String[] args) {
			Socket socket = null;
			PrintWriter netOut = null;

			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			String message = null;
			String username = null;

			try {
				System.out.println("Enter Username: ");
				username = in.readLine();
				
				System.out.println("Enter Message: ");
				message = in.readLine();
			} catch (IOException e) {
				System.err.println("Error reading message from user");
			}

			try {
				socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
			} catch (UnknownHostException e) {
				System.err.println("Unkown host: " + SERVER_ADDRESS);
			} catch (IOException e) {
				System.err.println("IOException while connecting" );
			}

			if (socket != null) {
				try {
					netOut = new PrintWriter(socket.getOutputStream(), true);
				} catch (IOException e) {
					System.err.println("IOException while opening connection");
				}
			}

			if (netOut != null && username != null && message != null ) {
				netOut.write(username + " : " + message);
				netOut.flush();
			} else {
				System.err.println("Something went wrong");
			}
			if (netOut != null) {
				netOut.close();
			}
		}

}
