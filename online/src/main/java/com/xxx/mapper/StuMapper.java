package com.xxx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xxx.po.Stu;

public interface StuMapper {
	//根据班级id得到该班的所有学生
	public List<Stu> selectStuByClazzId(int clazzId);
	//修改学生 
	public int updateStu(Stu stu);
	//根据no和pwd查询一个学生
	public Stu selectStuByNoAndPwd(@Param("no")String no, @Param("pwd")String pwd);
}
