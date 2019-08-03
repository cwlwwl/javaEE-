package com.fs.test;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.fs.mapper.UserMapper;
import com.fs.po.User;
import com.xxx.util.DBUtil;

public class UserMapperTest {
	@Test
	public void insertTest() {
		SqlSession session = DBUtil.getSqlSessionFactory().openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setName("Ð¡Ã÷");
		user.setSex("ÄÐ");
		mapper.insertSelective(user);
		session.commit();
		session.close();
	}
	
	@Test
	public void updateByPrimaryKeySelectiveTest() {
		SqlSession session = DBUtil.getSqlSessionFactory().openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setId(15);
		user.setName("Íõìø");
		user.setSex("ÄÐ");
		user.setBirthday(new Date(2019-1900, 7-1, 16));
		user.setHeight(18.5f);
		mapper.updateByPrimaryKeySelective(user);
		session.commit();
		session.close();
	}
}













