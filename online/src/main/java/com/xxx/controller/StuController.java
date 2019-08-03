package com.xxx.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.po.Stu;
import com.xxx.service.IStuService;
import com.xxx.util.PublicDate;
import com.xxx.vo.Clazz;

@Controller
public class StuController {
	@Autowired
	private IStuService stuService;
	@RequestMapping("/intoStu.do")
	public String intoStu(int clazzId, String clazzName, HttpServletRequest req) {
		Clazz clazz = new Clazz();
		clazz.setId(clazzId);
		clazz.setName(clazzName);
		req.setAttribute("clazz", clazz);
		return "/WEB-INF/stu.jsp";//ת����stu.jsp
	}
	@ResponseBody
	@RequestMapping("/getStuByClazzId.do")
	public List<Stu> getStuByClazzId(int clazzId) {
		List<Stu> list = this.stuService.getAllStuByClazzId(clazzId);
		for (Stu stu : list) {
			System.out.println(stu);
		}
		return list;
	}
	
	//�޸�ѧ��
	@ResponseBody
	@RequestMapping("/updateStu.do")
	public String updateStu(Stu stu) {
		int r = this.stuService.updateStu(stu);
		if(r==1) {//�޸ĳɹ�
			return PublicDate.YES;
		}else {//�޸�ʧ��
			return PublicDate.NO;
		}
	}
	
	//����ѧ����ҳ��
	@RequestMapping("/toStuMain.do")
	public String toStuPage() {
		return "/WEB-INF/stuMain.html";
	}
	
	@RequestMapping("/toStuGrade.do")
	public String toStuGrade() {
		return "/WEB-INF/stuGrade.html";
	}
}


















