package com.drl.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 在drl文件中导入，用于打印日志
 *
 */
public class DrlFileLogService {
	
	private static final Logger log = LoggerFactory.getLogger(DrlFileLogService.class);
	
	public static void info(String ruleName, String ruleMsg) {
		log.info("ruleName:{}, ruleMsg:{}", ruleName, ruleMsg);
		System.out.println("ruleName:" + ruleName + ", ruleMsg:" + ruleMsg);
	}

}
