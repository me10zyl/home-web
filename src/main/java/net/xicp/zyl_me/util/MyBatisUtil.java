package net.xicp.zyl_me.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import net.xicp.zyl_me.configuration.PropertiesLoader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class MyBatisUtil {
	private static SqlSessionFactory sqlSessionFactory;
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
	private static SqlSession sqlSession;

	public static SqlSession getSqlSession() {
		sqlSession = threadLocal.get();
		if (sqlSession == null) {
			sqlSession = sqlSessionFactory.openSession();
			threadLocal.set(sqlSession);
		}
		return sqlSession;
	}
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	/*public static SqlSessionFactory buildSqlSessionFactory() {
		String path = mybatisConfigurationPath;
		InputStream inputStream = null;
		try {
			File f = new File("");
			System.out.println(f.getCanonicalPath());
			inputStream = Resources.getResourceAsStream(path);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sqlSessionFactory;
	}*/

	public static void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		MyBatisUtil.sqlSessionFactory = sqlSessionFactory;
	}
}
