package com.xxx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xxx.po.Clazz;

public interface ClazzMapper {
	/**������еİ༶*/
	public List<Clazz> selectAll();
	/**����һ���༶*/
	public int insertClazz(Clazz clazz);
	/**����idɾ��һ���༶*/
	public int deleteById(@Param("id")int id);
	/**ģ����ѯ*/
	public List<Clazz> selectByIdNameMajor(Clazz clazz);
}
