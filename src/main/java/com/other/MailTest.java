package com.other;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@Lazy(false)
public class MailTest {
	
	public void sendMail() throws Exception{
		// 不是web工程不能用这行
//		ApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
		String[] xmlPathArr = new String[]{"classpath:applicationContext.xml"};
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(xmlPathArr); 
		JavaMailSender javaMailSender = ctx.getBean(JavaMailSender.class);
		
		
		MimeMessageHelper helper = new MimeMessageHelper(javaMailSender.createMimeMessage(), true, "UTF-8");
		
		helper.setSubject("test send mail");
		helper.setFrom("1@qq.com");
		helper.setTo("2@qq.com");
		helper.setCc("3@qq.com");
//		helper.setBcc("");
		helper.setText("hello world");
		
		javaMailSender.send(helper.getMimeMessage());
		System.out.println("end");
		
	}
	
	public static void main(String[] arg) throws Exception{
		String[] xmlPathArr = new String[]{"classpath:applicationContext.xml"};
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(xmlPathArr); 
		MailTest mailTest = ctx.getBean(MailTest.class);
		mailTest.sendMail();
	}

}
