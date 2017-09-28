package com.base.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext*.xml" ,"classpath:spring-mvc.xml"
})
@Transactional
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)   
public class BaseTest extends AbstractTransactionalJUnit4SpringContextTests{

}
