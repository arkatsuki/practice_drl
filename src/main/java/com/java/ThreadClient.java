package com.java;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.drl.service.RunRulesService;

public class ThreadClient {
	
	protected static final Logger log = LoggerFactory.getLogger(ThreadClient.class);
	
    public static void main(String[] args) throws InterruptedException, ExecutionException{
    	ExecutorService executor = Executors.newCachedThreadPool();
    	ThreadTaskCallable task = new ThreadTaskCallable();
        Future<String> result = executor.submit(task);
        System.out.println("ThreadClient, submit end");
        log.info("ThreadClient, submit end");
        executor.shutdown();
        
        while(!result.isDone()){
        	log.info("ThreadClient,job not done, sleep");
        	Thread.sleep(1000);
        }
        String value = result.get()==null?"no value":result.get();
        log.info("ThreadClient, job end, result: {}", value);
    }
	
}
