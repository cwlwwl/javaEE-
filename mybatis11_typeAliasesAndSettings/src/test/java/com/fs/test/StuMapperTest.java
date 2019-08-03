package com.fs.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.fs.mapper.StuMapper;
import com.fs.po.Stu;
import com.fs.util.DBUtil;

public class StuMapperTest {
	@Test
	public void selectAllTest() {
		SqlSessionFactory f = DBUtil.getSqlSessionFactory();
		SqlSession s = f.openSession();
		StuMapper mapper = s.getMapper(StuMapper.class);
		List<Stu> list = mapper.selectAll();
		s.close();
		for (Stu stu : list) {
			System.out.println(stu);
		}
	}
}
