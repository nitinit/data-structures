package com.interview.questions.bsb;

public class Time {

	private Long timeout;
	private Long currentTime;

	public Time(Long timeout, long currentTime) {
		this.timeout = timeout;
		this.currentTime = currentTime;
	}

	public Long getTimeout() {
		return timeout;
	}

	public void setTimeout(Long requestTime) {
		this.timeout = requestTime;
	}

	public Long getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Long currentTime) {
		this.currentTime = currentTime;
	}

}
