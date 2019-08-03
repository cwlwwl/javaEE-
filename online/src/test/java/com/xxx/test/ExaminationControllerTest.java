package com.xxx.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.xxx.controller.ExaminationController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class ExaminationControllerTest {
	//@Autowired
	@Resource//作用与Autowired相同
	private ExaminationController controller;
	
	@Test
	public void getExaminationNameTest() {
		String name = this.controller.getExaminationName(7);
		System.out.println(name);
	}
}
 