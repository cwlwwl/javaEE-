package com.xxx.service;

import java.util.List;

import com.xxx.po.Grade;

public interface IGradeService {
	/***
	 * ����stu_id�õ���ѧ�������гɼ�
	 */
	public List<Grade> getAllGradeByStuId(int stuId);
	/**
	 * �ύ����
	 */
	public int commitExamination(int stuId, int examinationId, String examinationName, float score);
}
