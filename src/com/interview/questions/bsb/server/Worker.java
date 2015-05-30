package com.interview.questions.bsb.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.interview.questions.bsb.KillHandler;
import com.interview.questions.bsb.RequestHandler;
import com.interview.questions.bsb.ServerStatus;
import com.interview.questions.bsb.SleepHandler;


public class Worker implements Runnable {

	private Socket socket = null;
	private InputStream input = null;
	private OutputStream output = null;
	private Request request = null;
	private Response response = null;
	private RequestHandler handler = null;

	public Worker(Socket socket) throws IOException {
		this.socket = socket;
		this.input = socket.getInputStream();
		output = socket.getOutputStream();
		request = new Request(input);
		response = new Response(output);
		request.parse();
	}

	@Override
	public void run() {
		if (request.getUri().indexOf("/sleep") != -1) {
			handler = new SleepHandler();
		} else if (request.getUri().indexOf("/server-status") != -1) {
			handler = new ServerStatus();
		} else if (request.getUri().indexOf("/sleep") != -1) {
			handler = new KillHandler();
		}

		if (handler != null) {
			handler.processRequest(request, response);
		}
		try {
			if (input != null) {
				input.close();
			}
			if (output != null) {
				output.close();
			}
			if(socket != null && !socket.isClosed()){
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
