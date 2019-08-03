package com.xxx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xxx.po.Examination;

public interface ExaminationMapper {
	public List<Examination> selectByStateAndClazzId(@Param("clazzId")int clazzId, @Param("state")int state);
	//根据班级id把修改该班中考试表的state的值为1
	public int updateExaminationStateByClazzId(int clazzId);
	//增加一个考试记录
	public int insertExamination(Examination examination);
	
	public Examination selectCurrentExaminationByStuId(int stuId);
}
