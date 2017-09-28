package com.base.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.drl.service.RunRulesService;
import com.other.FreemarkerTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext*.xml" ,"classpath:spring-mvc.xml"
})
public class Te {
    
	/**
	 * 如果像BaseTest那样继承AbstractTransactionalJUnit4SpringContextTests，就要配datasource
	 */
	
	
	@Test
	public void te2() throws Exception{
		FreemarkerTest ft = new FreemarkerTest();
		ft.generateRuleFile1();
	}
	
}
