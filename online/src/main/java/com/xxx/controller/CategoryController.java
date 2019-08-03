package com.xxx.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.mapper.CategoryMapper;
import com.xxx.po.Category;
import com.xxx.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService service;
	@ResponseBody
	@RequestMapping("/getAllCategory.do")
	public List<Category> getAllCategory() {
		try {
			List<Category> list = this.service.getAll();
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			String eInf = new Date()+"CategoryController,getAllCategory():--->"+e.getMessage();
			//文件输出流把eIinf保存在文件中
			return new ArrayList<Category>();
		}
	}
}














