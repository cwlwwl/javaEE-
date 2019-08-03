package com.xxx.service;

import java.util.List;

import com.xxx.po.Stu;

public interface IStuService {
	public List<Stu> getAllStuByClazzId(int clazzId);
	/**修改学生*/
	public int updateStu(Stu stu);
	/**学生登陆*/
	public Stu login(String no, String pwd);
}
