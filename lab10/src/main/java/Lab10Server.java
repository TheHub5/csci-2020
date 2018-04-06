import java.io.*;
import java.net.*;

public class Lab10Server {
	protected ServerSocket serverSocket = null;
	public static int SERVER_PORT = 49000;

	public Lab10Server () {
		try {
			serverSocket = new ServerSocket(SERVER_PORT);
			System.out.println("Server Listening on port " + SERVER_PORT);
			while (true) {
				Lab10ServerThread serverThread = new Lab10ServerThread(serverSocket.accept());
				serverThread.start();
			}
		} catch (Exception e) {
			System.err.println("Error creating server connection.");
		}
	}

	public static void  main (String[] args) {
		Lab10Server server = new Lab10Server();
	}
}
