package com.xxx.mapper;

import java.util.List;

import com.xxx.po.Category;

public interface CategoryMapper {
	/**查出所有的category数据*/
	public List<Category> selectAll();
}
