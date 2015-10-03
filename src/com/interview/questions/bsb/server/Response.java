package com.interview.questions.bsb.server;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import com.interview.questions.bsb.handlers.Time;


public class Response {

	private OutputStream output;

	public Response(OutputStream output) {
		this.output = output;
	}

	public void setInvalidRequest() throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("HTTP/1.1 404 Not Found").append("\r\n");
		sb.append("Content-Type: text/text").append("\r\n");
		output.write(sb.toString().getBytes());
	}

	public void sendSuccess() throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("HTTP/1.1 200 OK").append("\r\n");
		sb.append("Content-Type: text/json").append("\r\n");
		sb.append("\r\n");
		sb.append("{\"stat\":\"ok\"}");
		output.write(sb.toString().getBytes());
	}

	public void sendActiveConnectionInfo(ConcurrentMap<Integer, Time> map) throws IOException {
		StringBuilder sb = new StringBuilder();
		sb.append("HTTP/1.1 200 OK").append("\r\n");
		sb.append("Content-Type: text/text").append("\r\n");
		sb.append("\r\n");
		sb.append("Id").append("\t").append("time left");
		sb.append("\r\n----------------------------------------\r\n");
		for (Map.Entry<Integer, Time> m : map.entrySet()) {
			sb.append("\r\n");
			Time time = m.getValue();
			Long systime = System.currentTimeMillis();
			long t = time.getTimeout() - (systime - time.getCurrentTime());
			sb.append(m.getKey()).append("\t").append(t/1000).append(" seconds");
		}
		output.write(sb.toString().getBytes());
	}
}
