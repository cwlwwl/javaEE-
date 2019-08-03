package com.xxx.service;

import java.util.List;

import com.xxx.po.Examination;

public interface IExaminationService {
	/**
	 * @param clazzId 
	 * @param state
	 * @return ��ǰ�༶���ڽ��еĿ���
	 */
	public List<Examination> getByStateAndClazzId(int clazzId, int state);
	/**
	 * ������ǰ�༶�Ŀ���
	 */
	public int endExaminationOfCurrentClazz(int clazzId);
	
	/**��������*/
	public int publishExaminination(int clazzId, String examinationName, int subjectNum, int teacherId, String category);
	
	/**�鿴��ǰѧ�����ڰ༶���ڽ��еĿ���*/
	public Examination getCurrentExaminationByStuId(int stuId);
}
