package net.xicp.zyl_me;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import net.xicp.zyl_me.dal.entity.MessageBoard;
import net.xicp.zyl_me.util.MyBatisUtil;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("/conf/spring.xml")
@ActiveProfiles("dev")
public class MybatisTest {
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession session;
	@Autowired
	private MyBatisUtil util;
	@Value("${mybatis.configuration.path}")
	private static String test;
	@Before
	public void init() throws IOException {
		// File dir = new File(""); 这是获取项目根路径
		// File file = new File("conf/mybatis.xml");//参数为空
		String path = "conf/mybatis.xml";
		// String projectPath = file.getCanonicalPath();
		InputStream inputStream = Resources.getResourceAsStream(path);// 自带项目跟路径(相当于/conf/mybatis.xml)
		// InputStream inputStream =
		// this.getClass().getResourceAsStream("/conf/mybatis.xml");
		// System.out.println(inputStream.getFile());
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void test1() {
		session = sqlSessionFactory.openSession();
		try {
			MessageBoard msgBoard = (MessageBoard) session.selectOne("selectMessageBoardById", 1);
			System.out.println(msgBoard);
		} finally {
			session.close();
		}
	}

	@Test
	public void test2() {
		session =  MyBatisUtil.getSqlSession();
		try {
			List<MessageBoard> list = session.selectList("selectMessaBoradAll");
			for (MessageBoard m : list) {
				System.out.println(m);
			}
		} finally {
			session.close();
		}
	}

	@Test
	public void test3(){
		System.out.println(test);
	}
}
