import java.io.*;
import java.net.*;

public class Lab10ServerThread extends Thread {
	protected Socket socket = null;
	protected BufferedReader in = null;

	public Lab10ServerThread(Socket socket) {
		super();
		this.socket = socket;

		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			System.err.println("IOException while opening connection");
		}
	}


	public void run() {
		try {
			String msg = "";
			String line;
			while ((line = in.readLine()) != null) {
				msg += line;
			}
			socket.close();
			System.out.println(msg);

		} catch (IOException e) {
			System.err.println("Error while reading message");
		}
	}

}
