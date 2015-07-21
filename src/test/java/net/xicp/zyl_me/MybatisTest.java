package net.xicp.zyl_me;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import net.xicp.zyl_me.dal.entity.MessageBoard;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class MybatisTest {

	private SqlSessionFactory sqlSessionFactory;
	private SqlSession session;
	@Before
	public void init() throws IOException{
		//File dir = new File(""); 这是获取项目根路径
//		File file = new File("conf/mybatis.xml");//参数为空
		String path = "conf/mybatis.xml";
//		String projectPath = file.getCanonicalPath();
		InputStream inputStream = Resources.getResourceAsStream(path);//自带项目跟路径(相当于/conf/mybatis.xml)
//		InputStream inputStream = this.getClass().getResourceAsStream("/conf/mybatis.xml");
//		System.out.println(inputStream.getFile());
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	@Test
	public void test1(){
		session = sqlSessionFactory.openSession();
		try {
		  MessageBoard msgBoard = (MessageBoard) session.selectOne("selectMessageBoardById", 1);
		  System.out.println(msgBoard);
		} finally {
		  session.close();
		}
	}

	@Test
	public void test2(){
		session = sqlSessionFactory.openSession();
		try {
			List<MessageBoard> list = session.selectList("selectMessaBoradAll");
			for(MessageBoard m : list)
			{
				System.out.println(m);
			}
		}finally{
			session.close();
		}
	}
}
