package com.xxx.service;

import java.util.List;

import com.xxx.po.Grade;

public interface IGradeService {
	/***
	 * 根据stu_id得到该学生的所有成绩
	 */
	public List<Grade> getAllGradeByStuId(int stuId);
	/**
	 * 提交考试
	 */
	public int commitExamination(int stuId, int examinationId, String examinationName, float score);
}
