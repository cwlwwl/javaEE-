package com.xxx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.mapper.CategoryMapper;
import com.xxx.po.Category;

@Service
public class CategoryService implements ICategoryService {
	@Autowired
	private CategoryMapper mapper;
	@Override
	public List<Category> getAll() {
		return this.mapper.selectAll();
	}

}
