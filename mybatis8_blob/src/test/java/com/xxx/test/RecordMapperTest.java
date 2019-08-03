package com.xxx.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.xxx.mapper.RecordMapper;
import com.xxx.po.Record;
import com.xxx.util.DBUtil;

public class RecordMapperTest {
	
	private static byte[] readData(BufferedInputStream bin, int size, int max) {
		byte[] data = new byte[size];
		int hasRead = 0;
		while (true) {
			if (max > size - hasRead) {
				max = size - hasRead;
			}
			try {
				hasRead = hasRead + bin.read(data, hasRead, max);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (hasRead == size) {
				break;
			}
		}
		return data;
	}
	
	//���ص����ļ����ڿյ�byte[]��ʽ
	private byte[] getBytes(String filePath) throws Exception {
		InputStream is = new FileInputStream(filePath);
		BufferedInputStream bis = new BufferedInputStream(is);
		byte[] b = readData(bis, is.available(), 1024);
		return b;
	}
	
	@Test
	public void tewst() throws Exception {
		byte[] b = this.getBytes("E:/wgr.txt");
		String s = new String(b);
		System.out.println(s);
	}
	
	
	//ʹ�ü����ֶηֱ�洢���ַ�����xls�ļ���png�ļ���mp3�ļ���
	@Test
	public void insertTest() throws Exception {
		SqlSession session = DBUtil.getSqlSessionFactory().openSession();
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		
		Record record = new Record();
		record.setMytinyblob("�������".getBytes());
		record.setMyblob(this.getBytes("src/test/java/com/xxx/test/names.xls"));
		record.setMymediumblob(this.getBytes("src/test/java/com/xxx/test/��ɡ.png"));
		record.setMylongblob(this.getBytes("src/test/java/com/xxx/test/��ɡ.png"));
		
		mapper.insert(record);
		session.commit();
		session.close();
	}
	
	//����id���һ����¼��ȡ�����е�xls�ļ����ݣ����浽"d:/names.xls"��,ȡ�����е�pngͼƬ���ݣ��洢��"d:/ys.png"
	@Test
	public void selectById() throws Exception {
		SqlSession session = DBUtil.getSqlSessionFactory().openSession();
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		Record record = mapper.selectById(2);
		session.close();
		
		byte[] mytinyblob = record.getMytinyblob();
		String str_mytinyblob = new String(mytinyblob);
		System.out.println(str_mytinyblob);
		
		byte[] myblob = record.getMyblob();
		OutputStream out = new FileOutputStream("E:/���������.xls");
		out.write(myblob);
		out.flush();
		out.close();
		
		byte[] mymediumblob = record.getMymediumblob();
		OutputStream out2 = new FileOutputStream("E:/������.png");
		out2.write(mymediumblob);
		out2.flush();
		out2.close();
	}
}










