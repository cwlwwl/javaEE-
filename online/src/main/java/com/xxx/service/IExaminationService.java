package com.xxx.service;

import java.util.List;

import com.xxx.po.Examination;

public interface IExaminationService {
	/**
	 * @param clazzId 
	 * @param state
	 * @return 当前班级正在进行的考试
	 */
	public List<Examination> getByStateAndClazzId(int clazzId, int state);
	/**
	 * 结束当前班级的考试
	 */
	public int endExaminationOfCurrentClazz(int clazzId);
	
	/**发布考试*/
	public int publishExaminination(int clazzId, String examinationName, int subjectNum, int teacherId, String category);
	
	/**查看当前学生所在班级正在进行的考试*/
	public Examination getCurrentExaminationByStuId(int stuId);
}
