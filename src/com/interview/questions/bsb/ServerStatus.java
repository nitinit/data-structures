package com.interview.questions.bsb;

import java.io.IOException;

import com.interview.questions.bsb.server.Request;
import com.interview.questions.bsb.server.Response;


public class ServerStatus extends RequestHandler {

	@Override
	public void processRequest(Request request, Response response) {
		try {
			if (request.isGetMethod()) {
				response.sendActiveConnectionInfo(map);
				return;
			}
			response.setInvalidRequest();
		} catch (IOException e) {

		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
