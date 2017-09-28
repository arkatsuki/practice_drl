package com.base.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.drl.service.RunRulesService;

public class TEstAA extends BaseTest {
    
	@Autowired
	private RunRulesService runRulesService;
	
	@Test
	public void te1() throws InterruptedException{
		runRulesService.run1();
		
	}
	
}
