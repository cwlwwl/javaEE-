package com.xxx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.mapper.SubjectMapper;
import com.xxx.po.Subject;

@Service
public class SubjectService implements ISubjectService {
	@Autowired
	private SubjectMapper mapper;
	
	/***
	 * categoryIdes:"{ 1, 2, 7 } "
	 * num:���ٵ���
	 * return: ���ط��������������num��ʦ
	 */
	@Override
	public List<Subject> getSubjectByCategoryIdAndNum(String categoryIdes, int num) {
		//ȥ�����пո�
		categoryIdes = categoryIdes.replaceAll("(\\s|\\{|\\})", "");
		String[] a = categoryIdes.split(",");//["1","2","7"]
		int[] b = new int[a.length];
		for(int i=0; i<a.length; i++) {
			 b[i]=Integer.parseInt(a[i]);//[1,2,7]
		}
		List<Subject> list = this.mapper.selectSubjectByCategoryIdAndNum(b, num);
		return list;
	}
//	public static void main(String[] args) {
//		String s ="{ 11, 22, 766 } "; 
//		s = s.replaceAll("(\\s|\\{|\\})", "");//"11,22,766"
//		String[] a = s.split(",");
//		for (String str : a) {
//			System.out.println(str);
//		}
//	}
}
