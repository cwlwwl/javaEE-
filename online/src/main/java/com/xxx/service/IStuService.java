package com.xxx.service;

import java.util.List;

import com.xxx.po.Stu;

public interface IStuService {
	public List<Stu> getAllStuByClazzId(int clazzId);
	/**�޸�ѧ��*/
	public int updateStu(Stu stu);
	/**ѧ����½*/
	public Stu login(String no, String pwd);
}
