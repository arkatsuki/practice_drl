package com.drl.config;

import java.util.List;
import java.util.Properties;

import org.drools.core.SessionConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Message.Level;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.internal.io.ResourceFactory;

public class KieConfig {
	
	public static KieServices createKieService(String drlPath){
		KieServices kieServices = KieServices.Factory.get();
		KieFileSystem kfs = kieServices.newKieFileSystem();
		kfs.write(ResourceFactory.newFileResource(drlPath));
		
		KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();

		if (kieBuilder.getResults().hasMessages(Level.ERROR)) {
			List<Message> errors = kieBuilder.getResults().getMessages(Level.ERROR);
			StringBuilder sb = new StringBuilder("Errors:");
			for (Message msg : errors) {
				sb.append("\n  " + msg);
			}
			throw new RuntimeException(sb.toString());
		}
		return kieServices;
	}
	
	public static KieContainer createKieContainer(KieServices kieServices){
		KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
		return kieContainer;
	}
	
	public static KieSession createKieSession(KieServices kieServices, KieContainer kieContainer, Properties droolsProperties){
		KieSession kieSession = null;
		
		KieSessionConfiguration conf;
		if (droolsProperties == null) {
			conf = SessionConfiguration.getDefaultInstance();
		} else {
			conf = SessionConfiguration.newInstance(droolsProperties);
		}
		kieSession = kieContainer.newKieSession(conf);
		
		return kieSession;
	}
	
	public static KieSession createKieSessionWithListener(KieServices kieServices, KieContainer kieContainer, Properties droolsProperties){
		KieSession kieSession = createKieSession(kieServices, kieContainer, droolsProperties);
		
		addListener(kieSession);
		
		return kieSession;
	}
	
	
	public static KieSession createKieSessionWithListener(String drlPath){
		
		KieServices kieService = createKieService(drlPath);
		KieContainer kieContainer = createKieContainer(kieService);
		KieSession kieSession = createKieSession(kieService, kieContainer, null);
		
		addListener(kieSession);
		
		return kieSession;
	}
	
	/**
	 * 给kieSession添加两个listener，TrackingAgendaEventListener监听规则匹配，TrackingWorkingMemoryEventListener监听kieSession里面的对象变化
	 * @param kieSession
	 */
	public static void addListener(KieSession kieSession){
		TrackingAgendaEventListener agendaEventListener = new TrackingAgendaEventListener();
		TrackingWorkingMemoryEventListener workingMemoryEventListener = new TrackingWorkingMemoryEventListener();

		kieSession.addEventListener(agendaEventListener);
		kieSession.addEventListener(workingMemoryEventListener);
	}

}
