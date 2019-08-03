package com.fs.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.fs.mapper.StuMapper;
import com.fs.mapper.TypeMapper;
import com.fs.po.Stu;
import com.fs.po.Type;
import com.fs.util.DBUtil;

public class TypeMapperTest {
	@Test
	public void selectAllTest() {
		SqlSessionFactory f = DBUtil.getSqlSessionFactory();
		SqlSession s = f.openSession();
		TypeMapper mapper =  s.getMapper(TypeMapper.class);
		List<Type> list = mapper.selectAll();
		s.close();
		for (Type type : list) {
			System.out.println(type);
		}
	}
}
