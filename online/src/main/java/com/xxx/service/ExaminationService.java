package com.xxx.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xxx.mapper.ExaminationMapper;
import com.xxx.po.Examination;

@Service
public class ExaminationService implements IExaminationService {
	@Autowired
	private ExaminationMapper mapper;
	
	@Override
	public List<Examination> getByStateAndClazzId(int clazzId, int state) {
		List<Examination> list = this.mapper.selectByStateAndClazzId(clazzId, state);
		return list;
	}

	@Override
	public int endExaminationOfCurrentClazz(int clazzId) {
		int r = this.mapper.updateExaminationStateByClazzId(clazzId);
		return r;
	}
	@Override
	public int publishExaminination(int clazzId, String examinationName, int subjectNum, int teacherId, String category) {
		Examination examination = new Examination(examinationName, subjectNum, new Date(), 1, clazzId, teacherId, category);
		int r = this.mapper.insertExamination(examination);
		return r;
	}

	@Override
	public Examination getCurrentExaminationByStuId(int stuId) {
		Examination e = this.mapper.selectCurrentExaminationByStuId(stuId);
		return e;
	}
}















