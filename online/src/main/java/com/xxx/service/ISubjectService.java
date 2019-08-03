package com.xxx.service;

import java.util.List;

import com.xxx.po.Subject;

public interface ISubjectService {
	//{1,2,7}
	public List<Subject> getSubjectByCategoryIdAndNum(String categoryIdes, int num);
}
