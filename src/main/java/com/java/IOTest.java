package com.java;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.bean.Company;

public class IOTest {
	
	public static String READ_FILE_PATH = "D:/temp/readFile.txt";
	public static String WRITE_FILE_PATH = "D:/temp/writeFile.txt";
	
	protected final Logger log  =  LoggerFactory.getLogger(IOTest. class ); 
	
	/**
	 * 使用FileInputStream读取文件
	 * @throws Exception
	 */
	public void rwFile0() throws Exception{
		log.info("rwFile0, begin");
		byte[] b = new byte[4];
		InputStream fis = new FileInputStream(READ_FILE_PATH);
		int len;
		StringBuilder sb = new StringBuilder();
		while((len=fis.read(b))!=-1){
			sb.append(new String(b,0,len));
		}
		fis.close();
		log.info("sb:{}",sb.toString());
	}
	
	/**
	 * 使用InputStreamReader读取文件
	 * @throws Exception
	 */
	public void rwFile1() throws Exception{
		log.info("rwFile1, begin");
		InputStream fis = new FileInputStream(READ_FILE_PATH);
		Reader ir = new InputStreamReader(fis,"UTF-8");
		char[] c = new char[4];
		int len;
		StringBuilder sb = new StringBuilder();
		while((len=ir.read(c))!=-1){
			sb.append(new String(c,0,len));
		}
		fis.close();
		ir.close();
		log.info("sb:{}",sb.toString());
	}
	
	/**
	 * 使用ObjectOutputStream写文件
	 * @throws Exception
	 */
	public void rwFile2() throws Exception{
		FileOutputStream fis = new FileOutputStream(WRITE_FILE_PATH);
		// ObjectOutputStream只能包装OutputStream，不能包装Writter，所以没法设置生成文件的编码格式。
		ObjectOutputStream oos = new ObjectOutputStream(fis);
		
		Company c1 = new Company();
		c1.setCode("jf");
		c1.setName("jiufu");
		c1.setTempVal("temp value");
		
		oos.writeObject(c1);
		oos.close();
		fis.close();
		log.info("rwFile2 end");
	}
	
	public static void main(String[] args) throws Exception{
		
		IOTest c = new IOTest();
		c.rwFile2();
		
	}

}
