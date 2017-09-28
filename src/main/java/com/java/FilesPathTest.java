package com.java;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilesPathTest {
	
	public static String READ_FILE_PATH = "D:/temp/readFile.txt";
	public static String WRITE_FILE_PATH = "D:/temp/writeFile.txt";
	public static String CONTENT = "title. \n first line. \n another sentence \n the end";
//	public static String CONTENT = "title2. \r first line. \r no more words \r the end";
	public static String DIRECROTY = "D:/temp/tempDir";
	
	protected final Logger log  =  LoggerFactory.getLogger(FilesPathTest. class ); 
	
	/**
	 * 写文件
	 * @throws Exception
	 */
	public void rwFile0() throws Exception{
		
		// Path实例只能用静态方法获取
		Path readPath = Paths.get(READ_FILE_PATH);
		
		// 文件存在，就先删除
		if(Files.isRegularFile(readPath)){
			log.info("deleting");
			Files.delete(readPath);
		}
		
		// 写文件
		Files.write(readPath, CONTENT.getBytes("utf-8"));
		
		log.info("rwFile0 end");
	}
	
	/**
	 * Files读写文件不用手动close()
	 * FileChannel
	 * @throws Exception
	 */
	public void rwFile1() throws Exception{
		
		// Path实例只能用静态方法获取
		Path readPath = Paths.get(READ_FILE_PATH);
		
		if(Files.isRegularFile(readPath)){
			byte[] bytes = Files.readAllBytes(readPath);
			log.info("bytes content:{}",new String(bytes,"UTF-8"));
			// 默认第二个参数是utf-8的Charset
//			List<String> allLines = Files.readAllLines(readPath);
		}else{
			log.info("file not exist");
		}
		
		log.info("rwFile1 end");
	}
	
	
	public void mFile0() throws Exception{
		
		// 创建一个目录
		Path tempDir = Paths.get(DIRECROTY);
		if(Files.isDirectory(tempDir)){
			log.info("tempDir is already exist");
		}else{
			Files.createDirectory(tempDir);
		}
		
		log.info("createDirectory end");
	}
	
	/**
	 * 复制文件
	 * @throws Exception
	 */
	public void copyFile0() throws Exception{
		
		// 创建一个目录
		Path readPath = Paths.get(READ_FILE_PATH);
		Path writePath = Paths.get(WRITE_FILE_PATH);
		// 源文件不存在，返回
		if(!Files.isRegularFile(readPath)){
			log.info("file not exist, return");
			return;
		}
		if(Files.isRegularFile(writePath)){
			Files.delete(writePath);
		}
		Files.copy(readPath, writePath);
		
		log.info("copyFile0 end");
	}
	
	
	
	public static void main(String[] args) throws Exception{
		
		FilesPathTest f = new FilesPathTest();
		f.copyFile0();
	}

}
