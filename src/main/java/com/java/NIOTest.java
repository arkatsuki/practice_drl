package com.java;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NIOTest {
	
	public static String READ_FILE_PATH = "D:/temp/readFile.txt";
	public static String WRITE_FILE_PATH = "D:/temp/writeFile.txt";
	public static String CONTENT = "title. \n first line. \n another sentence \n the end";
	
	protected final Logger log  =  LoggerFactory.getLogger(NIOTest. class ); 
	
	/**
	 * 填充
	 * @param charBuffer
	 * @param content
	 */
	public void fillCharBuffer(CharBuffer charBuffer, String content){
		char[] cArr = new char[1024];
		content.getChars(0, content.length(), cArr, 0);
		for(int i=0;i<content.length();i++){
			charBuffer.put(cArr[i]);
		}
	}
	
	/**
	 * 读取
	 * @param charBuffer
	 */
	public void drainCharBuffer(CharBuffer charBuffer){
		while(charBuffer.hasRemaining()){
			System.out.print(charBuffer.get());
		}
	}
	
	public void mBuffer0() throws Exception{
		
		
		CharBuffer charBuffer = CharBuffer.allocate(1024);
		// 装载内容
		fillCharBuffer(charBuffer,CONTENT);
		// 第二种创建方式：包装一个已有的数组
		
		// 翻转，将position指针设置到开头，准备输出
		charBuffer.flip();
		drainCharBuffer(charBuffer);
		charBuffer.clear();
		
		log.info("mBuffer0 end");
	}
	
	/**
	 * 使用FileChannel读文件
	 * @throws Exception
	 */
	public void mFileChannel() throws Exception{
		
//		byte[] b = new byte[1024];
		ByteBuffer bb = ByteBuffer.allocate(3);
		FileInputStream fis = new FileInputStream(READ_FILE_PATH);
		FileChannel fc = fis.getChannel();
		long position = 0l;
		position = fc.position();
		System.out.println("position:"+position);
		int pos = 0;
		pos = fc.read(bb);
		System.out.println("pos:"+pos);
		position = fc.position();
		System.out.println("position:"+position);
		bb.clear();
		pos = fc.read(bb);
		System.out.println("pos:"+pos);
		position = fc.position();
		System.out.println("position:"+position);
		bb.clear();
		
		if(fc.isOpen()){
			fc.close();
		}
		
		log.info("mFileChannel end");
	}
	
	public static void main(String[] args) throws Exception{
		
		NIOTest n = new NIOTest();
		n.mFileChannel();
		
	}
	
}
