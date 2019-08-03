package com.xxx.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xxx.po.Subject;
import com.xxx.service.ISubjectService;

@Controller
public class SubjectController {
	@Autowired
	private ISubjectService service;
	/**
	 * @param categoryIdes  "{1,2,7}" 
	 * @param num:题的数量
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getSubjectByCategoryIdAndNum.do")
	public List<Subject> getSubjectByCategoryIdAndNum(String categoryIdes, int num) {
		List<Subject> list = this.service.getSubjectByCategoryIdAndNum(categoryIdes, num);
		for (Subject subject : list) {
			System.out.println(subject);
		}
		return list;
	}
}












