package com.javaweb.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybaitsUtils {
	/**
	 * ��ȡSqlSession
	 * @return
	 */
	public static SqlSession getSqlSession(){
		try {
			InputStream in = Resources.getResourceAsStream("mybatis_config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in); 
			SqlSession sqlSession = factory.openSession();
			return sqlSession;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * �ύ���ر���Դ
	 * @param sqlSession
	 */
	public static void close(SqlSession sqlSession){
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	
	
}
