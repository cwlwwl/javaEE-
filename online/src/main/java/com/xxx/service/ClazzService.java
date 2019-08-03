package com.xxx.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xxx.mapper.ClazzMapper;
import com.xxx.po.Clazz;

@Service
public class ClazzService implements IClazzService {
	@Autowired
	private ClazzMapper mapper;

	@Override
	public List<com.xxx.vo.Clazz> getAllClazz() {
		List<com.xxx.po.Clazz> list1 = this.mapper.selectAll();
		List<com.xxx.vo.Clazz> list2 = new ArrayList<>();
		for (int i = 0; i < list1.size(); i++) {
			com.xxx.po.Clazz clazz = list1.get(i);
			list2.add(new com.xxx.vo.Clazz(clazz.getId(), clazz.getName(), clazz.getMajor(), clazz.strBeginDate()));
		}
		return list2;
	}

	@Override
	public int addClazz(Clazz clazz) {
		clazz.setBeginDate(new Date());
		int r = this.mapper.insertClazz(clazz);
		return r;
	}

	@Override
	public int deleteById(int id) {
		return this.mapper.deleteById(id);
	}
	
	@Override 
	public List<com.xxx.vo.Clazz> getClazzByLike(String key) {
		Clazz clazz = new Clazz();
		clazz.setMajor("%"+key+"%");
		clazz.setName("%"+key+"%");
		List<Clazz> list1 = this.mapper.selectByIdNameMajor(clazz);
		List<com.xxx.vo.Clazz> list2 = new ArrayList<>();
		for (int i = 0; i < list1.size(); i++) {
			com.xxx.po.Clazz myclazz = list1.get(i);
			list2.add(new com.xxx.vo.Clazz(myclazz.getId(), myclazz.getName(), myclazz.getMajor(),myclazz.strBeginDate()));
		}
		return list2;
	}
}
