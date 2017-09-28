package com.java;

import java.util.Random;
import java.util.concurrent.Callable;

public class ThreadTaskCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		
		String[] msgArr = {"a","b","c","d","e","f","g","h","i","j"};
		Random random = new Random();
		int i = random.nextInt(9);
		
		Thread.sleep(3000);
		
		return msgArr[i];
	}

}
