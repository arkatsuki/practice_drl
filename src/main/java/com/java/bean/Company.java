package com.java.bean;

import java.io.Serializable;
import java.util.List;

public class Company implements Serializable {
	
	private static final long serialVersionUID = 7544733641745552898L;

	/**
	 * ObjectInputStream与ObjectOutputStream类所读写的对象必须实现Serializable接口，对象中的transient和static类型成员变量不会被读取和写入
	 */
	
	private transient String tempVal;
	
	private String name;
	private String code;
	private List<String> managers;
	private List<String> employees;
	private List<String> department;
	
	public String getTempVal() {
		return tempVal;
	}
	public void setTempVal(String tempVal) {
		this.tempVal = tempVal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<String> getManagers() {
		return managers;
	}
	public void setManagers(List<String> managers) {
		this.managers = managers;
	}
	public List<String> getEmployees() {
		return employees;
	}
	public void setEmployees(List<String> employees) {
		this.employees = employees;
	}
	public List<String> getDepartment() {
		return department;
	}
	public void setDepartment(List<String> department) {
		this.department = department;
	}

}
