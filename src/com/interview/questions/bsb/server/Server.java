package com.interview.questions.bsb.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class Server {

	public static final int BACKLOG = 100;
	public static final int PORT = 9010;
	public static final String HOST = "127.0.0.1";

	public static void main(String[] args) {
		Server server = new Server();
		server.serviceRequest();
	}

	private void serviceRequest() {
		System.out.println("-------- Starting the server ----------");
		try {
			ServerSocket serverSocket = new ServerSocket(PORT, BACKLOG, InetAddress.getByName(HOST));
			while (true) {
				new Thread(new Worker(serverSocket.accept())).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
