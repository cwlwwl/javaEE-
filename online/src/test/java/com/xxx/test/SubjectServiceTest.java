package com.xxx.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xxx.po.Subject;
import com.xxx.service.ISubjectService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mapper.xml","classpath:spring/spring-service.xml"})
public class SubjectServiceTest {
	@Autowired
	ISubjectService service;
	
	@Test
	public void getSubjectByCategoryIdAndNumTest() {
		List<Subject> list = this.service.getSubjectByCategoryIdAndNum("{1,2,7}", 20);
		System.out.println(list);
	}
}
