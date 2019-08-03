package com.xxx.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xxx.mapper.StuMapper;
import com.xxx.po.Stu;

@Service
public class StuService implements IStuService {
	@Autowired
	private StuMapper stuMapper;
	@Override
	public List<Stu> getAllStuByClazzId(int clazzId) {
		return this.stuMapper.selectStuByClazzId(clazzId);
	}
	@Override
	public int updateStu(Stu stu) {
		int r = this.stuMapper.updateStu(stu);
		return r;
	}
	@Override
	public Stu login(String no, String pwd) {
		Stu stu = this.stuMapper.selectStuByNoAndPwd(no, pwd);
		return stu;
	}
}
