package com.fs.po;

import org.apache.ibatis.type.Alias;

public class Stu {
	private int id;
	private String name;
	private String sex;
	private int age;
	@Override
	public String toString() {
		return "Stu [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
