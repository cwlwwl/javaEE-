package com.xxx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xxx.po.Stu;

public interface StuMapper {
	//���ݰ༶id�õ��ð������ѧ��
	public List<Stu> selectStuByClazzId(int clazzId);
	//�޸�ѧ�� 
	public int updateStu(Stu stu);
	//����no��pwd��ѯһ��ѧ��
	public Stu selectStuByNoAndPwd(@Param("no")String no, @Param("pwd")String pwd);
}
