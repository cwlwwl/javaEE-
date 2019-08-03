package com.xxx.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.po.Stu;
import com.xxx.po.Teacher;
import com.xxx.service.IStuService;
import com.xxx.service.ITeacherService;

@Controller
public class CommonController {
	@Autowired
	private ITeacherService teacherService;
	
	@Autowired
	private IStuService stuService;
	
	@RequestMapping("/login.do")
	public String login(String no, String pwd, String role, HttpServletResponse response) {
		if ("teacher".equals(role)) {// ��ʦ��½
			Teacher teacher = this.teacherService.login(no, pwd);
			if (teacher != null) {// �ɹ�
				String teacherJson = null;
				try {
					// ת��
					teacherJson = URLEncoder.encode(teacher.toString(), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				Cookie cookie = new Cookie("teacher", teacherJson);
				cookie.setMaxAge(60 * 60 * 24); // ʱ��Ϊ��λ
				response.addCookie(cookie);
				return "/WEB-INF/teacher.html";
			} else {// ʧ��
				return "/login.html";
			}
		} else if ("student".equals(role)) {// ѧ����½
			return "/login.html";
		} else {// ������
			return "/login.html";
		}
	}
	// ����ajax��½
	@ResponseBody
	@RequestMapping(value="/ajaxLogin.do", method=RequestMethod.POST)
	public Object ajaxLogin(String no, String pwd, String role) {
			if("teacher".equals(role)) {//��ʦ��½ 
				Teacher teacher = this.teacherService.login(no, pwd);
				return teacher;
			}else if("student".equals(role)) {//ѧ����½
				Stu stu = this.stuService.login(no, pwd);
				return stu;
			}else {
				return null;
			}
	}
}












