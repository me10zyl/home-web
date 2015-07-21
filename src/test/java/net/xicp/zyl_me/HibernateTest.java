package net.xicp.zyl_me;

import net.xicp.zyl_me.dal.entity.MessageBoard;
import net.xicp.zyl_me.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("/conf/spring.xml")
public class HibernateTest {

	@Test
	public void test1() {
		Session session = HibernateUtil.getSession();
		MessageBoard message = (MessageBoard)session.get(MessageBoard.class, 1);
		System.out.println(message);
		session.close();
	}
}
