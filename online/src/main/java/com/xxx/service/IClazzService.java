package com.xxx.service;

import java.util.List;
import com.xxx.po.Clazz;
public interface IClazzService {
	public List<com.xxx.vo.Clazz> getAllClazz();
	/**ע��һ���༶*/
	public int addClazz(Clazz clazz);
	/**����idɾ��һ���༶*/
	public int deleteById(int id);
	/**����name��majorģ����ѯ�༶*/
	public List<com.xxx.vo.Clazz> getClazzByLike(String key);
}
