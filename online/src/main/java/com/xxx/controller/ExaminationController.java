package com.xxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.po.Examination;
import com.xxx.service.IExaminationService;
import com.xxx.util.PublicDate;

@Controller
public class ExaminationController {
	@Autowired
	private IExaminationService service;
	
	/**查出当前班级中正在进行的一个考试*/
	@ResponseBody
	@RequestMapping(value="getExaminationName.do", produces={"application/json;charset=UTF-8"})
	public String getExaminationName(int clazzId) {
		System.out.println(">>>>>>"+clazzId);
		List<Examination> list = this.service.getByStateAndClazzId(clazzId, 1);
		String examinationName = PublicDate.NO;
		if(list.size()==1) {
			Examination examination = list.get(0);
			examinationName = examination.getName();
		}
		return examinationName;
	}
	
	/**结束当前班级的考试*/
	@ResponseBody
	@RequestMapping(value="endExamination.do", produces={"application/json;charset=UTF-8"})
	public String endExamination(int clazzId) {
		int r = this.service.endExaminationOfCurrentClazz(clazzId);
		if(r>0) {
			return PublicDate.YES;
		}else {
			return PublicDate.NO;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="publishExamination.do", produces={"application/json;charset=UTF-8"})
	public String publishExamination(int clazzId, String examinationName, int subjectNum, int teacherId, String category) {
		int r = this.service.publishExaminination(clazzId, examinationName, subjectNum, teacherId, category);
		if(r==1) {
			return PublicDate.YES;
		}else {
			return PublicDate.NO;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="getCurrentExaminationByStuId.do")
	public Examination getCurrentExaminationByStuId(int stuId) {
		Examination e = this.service.getCurrentExaminationByStuId(stuId);
		return e;
	}
	@RequestMapping(value="toCurrentExamination.do")
	public String toCurrentExamination() {
		return "WEB-INF/currentExamination.html";
	}
}













