package com.xxx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xxx.mapper.GradeMapper;
import com.xxx.po.Grade;

@Service
public class GradeService implements IGradeService {
	@Autowired
	private GradeMapper gradeMapper;
	@Override
	public List<Grade> getAllGradeByStuId(int stuId) {
		List<Grade> list = this.gradeMapper.selectByStuId(stuId);
		return list;
	}

	@Override
	public int commitExamination(int stuId, int examinationId, String examinationName, float score) {
		//查看考试的次数
		Integer times = this.gradeMapper.selectTimesByExamination(examinationId, stuId);
		
		Grade grade = new Grade();
		grade.setStuId(stuId);
		grade.setExaminationId(examinationId);
		grade.setExaminationName(examinationName);
		grade.setScore(score);
		grade.setTimes(times==null ? 1 : (times+1));
		
		int r = this.gradeMapper.insertGrade(grade);
		return r;
	}
}
