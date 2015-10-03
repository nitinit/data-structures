package com.interview.questions.bsb.handlers;

import java.io.IOException;

import com.interview.questions.bsb.server.Request;
import com.interview.questions.bsb.server.Response;


public class SleepHandler extends RequestHandler {
	private static final long TIME = 1000;

	@Override
	public void processRequest(Request request, Response response) {
		try {
			if (request.isGetMethod()) {
				String u = request.getUri();
				if (u.indexOf("?") + 1 <= u.length()) {
					String uri = request.getUri().substring(u.indexOf("?") + 1);
					if (uri != null && !uri.isEmpty()) {
						String[] param = uri.split("[&]");
						Long timeout = Long.valueOf(param[0].substring(param[0].indexOf("=") + 1));
						Integer connid = Integer.valueOf(param[1].substring(param[1].indexOf("=") + 1));
						map.put(connid, new Time(TIME*timeout, System.currentTimeMillis()));
						Thread.sleep(TIME * timeout);
						
						map.remove(connid);
						response.sendSuccess();
						return;
					}
				}
			}
			response.setInvalidRequest();
		} catch (IOException e) {

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
