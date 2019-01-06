package com.login.app.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SAL implements HttpSessionListener{

	private static int sessionCount = 0;
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		sessionCount++;
		System.out.println("session created  = "+sessionCount);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		sessionCount--;
		System.out.println("session destroyed = "+sessionCount);
	}
}
