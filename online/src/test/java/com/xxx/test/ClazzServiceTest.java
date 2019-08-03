package com.xxx.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xxx.service.IClazzService;
import com.xxx.vo.Clazz;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mapper.xml","classpath:spring/spring-service.xml"})
public class ClazzServiceTest {
	@Autowired
	private IClazzService service;
	
	@Test
	public void getClazzByLikeTest() {
		List<Clazz> list = this.service.getClazzByLike("¶þ");
		for (Clazz clazz : list) {
			System.out.println(clazz);
		}
	}
}
