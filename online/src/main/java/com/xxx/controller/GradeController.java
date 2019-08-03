package com.xxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xxx.po.Grade;
import com.xxx.service.IGradeService;
import com.xxx.util.PublicDate;

@Controller
public class GradeController {
	@Autowired
	private IGradeService gradeService;

	// 根据学生的id得到该学生的所有成绩
	@ResponseBody
	@RequestMapping("getAllGradeByStuId.do")
	public List<Grade> getAllGradeByStuId(int stuId) {
		List<Grade> list = this.gradeService.getAllGradeByStuId(stuId);
		return list;
	}
	//提交成绩 
	@ResponseBody
	@RequestMapping("commitGrade.do")
	public String commitGrade(int stuId, int examinationId, String examinationName, float score) {
		int r = this.gradeService.commitExamination(stuId, examinationId, examinationName, score);
		if(r==1) {
			return PublicDate.YES;
		}else {
			return PublicDate.NO;
		}
	}
}





