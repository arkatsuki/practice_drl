package com.drl.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.drl.bean.Applicant;
import com.drl.bean.Fire;
import com.drl.bean.Room;
import com.drl.bean.Sprinkler;
import com.drl.config.KieConfig;

@Service
public class RunRulesService {
	
	private static final Logger log = LoggerFactory.getLogger(RunRulesService.class);
	
	public void run1(){
		// 要用path.getPath()获取文件路径，用path.toString()会带url的前缀file://
		URL path = RunRulesService.class.getResource("/rules/rule_1.drl");
		
		
		Applicant app = new Applicant();
		
		app.setAge(1);
		app.setName("a");
		app.setValid(true);
		log.info("valid:{}",app.isValid());
		
		KieSession kieSession = KieConfig.createKieSessionWithListener(path.getPath());
		FactHandle factHandle = kieSession.insert(app);
		kieSession.fireAllRules();
		
		kieSession.delete(factHandle);
		kieSession.destroy();
		
		log.info("valid:{}",app.isValid());
		System.out.println("valid:{}" + app.isValid());
		
	}
	
	public void run20(){
		URL path = RunRulesService.class.getResource("/rules/rule_2.drl");
		
		Room r1 = new Room("room1");
		Fire f1 = new Fire(r1);
		Sprinkler s1 = new Sprinkler(r1, false);
		
		Room r2 = new Room("room2");
		Fire f2 = new Fire(r2);
		Sprinkler s2 = new Sprinkler(r2, false);
		
		KieSession kieSession = KieConfig.createKieSessionWithListener(path.getPath());
		kieSession.insert(r1);
		kieSession.insert(s1);
		kieSession.insert(f1);
		kieSession.insert(r2);
		kieSession.insert(s2);
		kieSession.insert(f2);
		kieSession.fireAllRules();
		
		System.out.println("run2 end");
		
	}
	
	@SuppressWarnings("unchecked")
	public void run21(){
		URL path = RunRulesService.class.getResource("/rules/rule_2.drl");
		
		Room r1 = new Room("room1");
		Fire f1 = new Fire(r1);
		Sprinkler s1 = new Sprinkler(r1, false);
		
		Room r2 = new Room("room2");
		Fire f2 = new Fire(r2);
		Sprinkler s2 = new Sprinkler(r2, false);
		
		KieServices kieServices = KieConfig.createKieService(path.getPath());
		KieContainer kieContainer = KieConfig.createKieContainer(kieServices);
		KieSession kieSession = KieConfig.createKieSession(kieServices, kieContainer, null);
		kieSession.execute(kieServices.getCommands().newInsertElements(Arrays.asList(new Object[]{r1,s1,r2,s2,f1,f2})));
		kieSession.fireAllRules();
		
		System.out.println("run21 end");
		
	}
	
	
	public static void main(String[] args) throws IOException{
		
		log.info("begin");
		
		RunRulesService runRulesService = new RunRulesService();
		runRulesService.run21();
		
		log.info("end");
		
	}

}
