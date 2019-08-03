package com.xxx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xxx.po.Subject;

public interface SubjectMapper {
	public List<Subject> selectSubjectByCategoryIdAndNum(@Param("categoryIdes")int[] categoryIdes, @Param("num")int num);
}
