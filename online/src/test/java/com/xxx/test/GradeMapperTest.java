package com.xxx.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xxx.mapper.GradeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mapper.xml"})
public class GradeMapperTest {
	@Autowired
	GradeMapper mapper;
	@Test
	public void selectTimesByExaminationIdTest() {
		Integer r = this.mapper.selectTimesByExamination(2, 1);
		System.out.println(r);
	}
}
