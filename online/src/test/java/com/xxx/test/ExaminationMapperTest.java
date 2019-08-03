package com.xxx.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xxx.mapper.ExaminationMapper;
import com.xxx.po.Examination;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-mapper.xml"})
public class ExaminationMapperTest {
	
	@Autowired
	private ExaminationMapper mapper;
	
	@Test
	public void selectByStateAndClazzIdTest() {
		List<Examination> list = this.mapper.selectByStateAndClazzId(7, 1);
		for (Examination examination : list) {
			System.out.println(examination);
		}
	}
}
 