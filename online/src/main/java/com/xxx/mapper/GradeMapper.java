package com.xxx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xxx.po.Grade;

public interface GradeMapper {
	public List<Grade> selectByStuId(@Param("stuId")int stuId);
	public int insertGrade(Grade grade);
	public Integer selectTimesByExamination(@Param("examinationId")int examinationId, @Param("stuId")int stuId);
}
