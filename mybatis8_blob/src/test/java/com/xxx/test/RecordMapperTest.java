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
	
	//返回的是文件的内空的byte[]格式
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
	
	
	//使用几个字段分别存储了字符串，xls文件，png文件，mp3文件。
	@Test
	public void insertTest() throws Exception {
		SqlSession session = DBUtil.getSqlSessionFactory().openSession();
		RecordMapper mapper = session.getMapper(RecordMapper.class);
		
		Record record = new Record();
		record.setMytinyblob("你好世界".getBytes());
		record.setMyblob(this.getBytes("src/test/java/com/xxx/test/names.xls"));
		record.setMymediumblob(this.getBytes("src/test/java/com/xxx/test/雨伞.png"));
		record.setMylongblob(this.getBytes("src/test/java/com/xxx/test/雨伞.png"));
		
		mapper.insert(record);
		session.commit();
		session.close();
	}
	
	//根据id查出一条记录。取出其中的xls文件内容，保存到"d:/names.xls"中,取出其中的png图片内容，存储到"d:/ys.png"
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
		OutputStream out = new FileOutputStream("E:/华清的名单.xls");
		out.write(myblob);
		out.flush();
		out.close();
		
		byte[] mymediumblob = record.getMymediumblob();
		OutputStream out2 = new FileOutputStream("E:/这是雨.png");
		out2.write(mymediumblob);
		out2.flush();
		out2.close();
	}
}










