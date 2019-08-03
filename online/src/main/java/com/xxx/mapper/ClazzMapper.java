package com.xxx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xxx.po.Clazz;

public interface ClazzMapper {
	/**查出所有的班级*/
	public List<Clazz> selectAll();
	/**加入一个班级*/
	public int insertClazz(Clazz clazz);
	/**根据id删除一个班级*/
	public int deleteById(@Param("id")int id);
	/**模糊查询*/
	public List<Clazz> selectByIdNameMajor(Clazz clazz);
}
