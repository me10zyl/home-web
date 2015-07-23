package net.xicp.zyl_me;

import static org.junit.Assert.fail;

import java.util.List;

import junit.framework.TestCase;
import net.xicp.zyl_me.dal.dao.MessageBoardDAO;
import net.xicp.zyl_me.dal.entity.MessageBoard;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("/conf/spring.xml")
@ActiveProfiles("dev")
public class MessageBoardDAOTest {
	@Autowired
	private MessageBoardDAO dao;

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Test
	public void testDelete() {
		MessageBoard messageBoard = new MessageBoard();
		messageBoard.setId(7);
		dao.delete(messageBoard);
		testList();
	}

	@Test
	public void testUpdate() {
		MessageBoard messageBoard = dao.findById(8);
		String str = "i ' m be updated 2!!!";
		messageBoard.setContent(str);
		dao.update(messageBoard);
		testList();
		System.out.println(messageBoard.getContent());
		TestCase.assertEquals(messageBoard.getContent(), str);
	}

	@Test
	public void testFindByIdInt() {
		MessageBoard messageBoard = dao.findById(1);
		System.out.println(messageBoard);
	}

	@Test
	public void testList() {
		List<MessageBoard> list = dao.list();
		for(MessageBoard m : list)
		{
			System.out.println(m);
		}
	}

	@Test
	public void testSaveMessageBoard() {
		MessageBoard messageBoard = dao.findById(1);
		dao.save(messageBoard);
		testList();
	}
}
