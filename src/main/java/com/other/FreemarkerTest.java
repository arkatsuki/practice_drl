package com.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.drl.bean.Rule;

@Component
public class FreemarkerTest {
	
	@Autowired
//	private Configuration freemarkerConfiguration;
	private FreeMarkerConfigurer freemarkerConfiguration;
	
	public void generateRuleFile1() throws Exception{
		
		List<Rule> ruleList = new ArrayList<>();
		Rule r = new Rule();
		r.setCode("rc1");
		r.setName("rn1");
		ruleList.add(r);
		
		Map<String, Object> map = new HashMap<>();

		map.put("ruleList", ruleList);
		
		StringBuilder sb = new StringBuilder();
//		sb.append(FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfiguration.getTemplate("fm_userDeleted.txt"), map));
		sb.append(FreeMarkerTemplateUtils.processTemplateIntoString(freemarkerConfiguration.getConfiguration().getTemplate("freemarker1.ftl"), map));
		System.out.println("end， sb:"+sb.toString());
		
	}
	
	public static void main(String[] arg) throws Exception{
		String[] xmlPathArr = new String[]{"classpath:applicationContext.xml"};
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(xmlPathArr); 
		FreemarkerTest freemarkerTest = ctx.getBean(FreemarkerTest.class);
		freemarkerTest.generateRuleFile1();
	}

}
