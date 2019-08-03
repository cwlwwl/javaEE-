package com.xxx.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xxx.vo.Clazz;
import com.xxx.service.IClazzService;
import com.xxx.util.PublicDate;

@Controller
public class ClazzController {
	@Autowired
	private IClazzService clazzSerivce;
	
	@ResponseBody
	@RequestMapping(value="/getAllClazz.do")
	public List<Clazz> getAllClazz() {
		List<Clazz> list = this.clazzSerivce.getAllClazz();
		return list;
	}
	@ResponseBody
	@RequestMapping(value="/addClazz.do", method=RequestMethod.POST)
	public String addClazz(String name, String major) {
		com.xxx.po.Clazz clazz = new com.xxx.po.Clazz();
		clazz.setName(name);
		clazz.setMajor(major);
		int r = this.clazzSerivce.addClazz(clazz);
		if(r==1) {//增加成功
			return PublicDate.YES;
		}else {//增加失败
			return PublicDate.NO;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteById.do", method=RequestMethod.POST)
	public String deleteById(int id) {
		int r = this.clazzSerivce.deleteById(id);
		if(r==1) {//删除成功
			return PublicDate.YES;
		}else {//删除失败
			return PublicDate.NO;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/getClazzByLike.do")
	public List<Clazz> getClazzByLike(String key) {
		List<Clazz> list = this.clazzSerivce.getClazzByLike(key);
		return list;
	}
	
	@RequestMapping("/clazz.do")
	public String clazz(HttpServletRequest req) {
		return "/WEB-INF/clazz.html";
	}
}



















