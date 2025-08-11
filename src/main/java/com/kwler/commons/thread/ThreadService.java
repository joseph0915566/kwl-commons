package com.kwler.commons.thread;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author Joseph Siegar
 *
 */
public class ThreadService {
	
	public void sleepMillis(long millis) throws InterruptedException{
		if(millis <= 0) return;
		try {
			TimeUnit.MILLISECONDS.sleep(millis);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw e;
		}
	}
	
}
