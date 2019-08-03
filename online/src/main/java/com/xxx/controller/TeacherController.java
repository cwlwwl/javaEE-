package com.xxx.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherController {
	@RequestMapping("/subject.do")
	public String subject(HttpServletRequest req) {
		boolean flag = false;//�Ƿ��½��
		Cookie[] cookies = req.getCookies();
		if(cookies == null) {//���cookieΪnull
			return "/login.html";
		}else {//���cookie��Ϊnull,
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				if("teacher".equals(name)) {
					flag = true;
					break;
				}
			}
			if(flag) {//��½��
				return "/WEB-INF/subject.html";
			}else {//û�е�½��
				return "/login.html";
			}
		}
	}
	@RequestMapping("/toTeacherPage.do")
	public String toTeacherPage() {
		return "/WEB-INF/teacher.html";
	}
}

























