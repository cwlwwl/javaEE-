package com.xxx.service;

import java.util.List;
import com.xxx.po.Clazz;
public interface IClazzService {
	public List<com.xxx.vo.Clazz> getAllClazz();
	/**注册一个班级*/
	public int addClazz(Clazz clazz);
	/**根据id删除一个班级*/
	public int deleteById(int id);
	/**根据name和major模糊查询班级*/
	public List<com.xxx.vo.Clazz> getClazzByLike(String key);
}
