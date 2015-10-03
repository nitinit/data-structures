package com.interview.questions.bsb.handlers;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.interview.questions.bsb.server.Request;
import com.interview.questions.bsb.server.Response;


public abstract class RequestHandler {

	public static ConcurrentMap<Integer, Time> map = new ConcurrentHashMap<Integer, Time>();
	
	public abstract void processRequest(Request request, Response response);
}
