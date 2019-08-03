package com.xxx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xxx.po.Examination;

public interface ExaminationMapper {
	public List<Examination> selectByStateAndClazzId(@Param("clazzId")int clazzId, @Param("state")int state);
	//���ݰ༶id���޸ĸð��п��Ա��state��ֵΪ1
	public int updateExaminationStateByClazzId(int clazzId);
	//����һ�����Լ�¼
	public int insertExamination(Examination examination);
	
	public Examination selectCurrentExaminationByStuId(int stuId);
}
