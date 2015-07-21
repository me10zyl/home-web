package net.xicp.zyl_me.dal.dao;

import java.util.ArrayList;
import java.util.List;

import net.xicp.zyl_me.dal.entity.MessageBoard;
import net.xicp.zyl_me.util.HibernateUtil;
import net.xicp.zyl_me.util.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Repository
public class MessageBoardDAO extends DataAccessObject<MessageBoard> {
	@Override
	public MessageBoard findById(int id) {
		Session session = HibernateUtil.getSession();
		MessageBoard messageBoard = (MessageBoard) session.get(MessageBoard.class, id);
		return messageBoard;
	}

	@Override
	public List<MessageBoard> list() {
		List<MessageBoard> messageBoards = new ArrayList<MessageBoard>();
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		messageBoards = sqlSession.selectList("selectMessaBoradAll");
		sqlSession.close();
		return messageBoards;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void delete(MessageBoard messageBoard) {
		Session session = HibernateUtil.getSession();
		// Transaction transaction = session.beginTransaction();
		session.delete(messageBoard);
		// transaction.commit();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void update(MessageBoard messageBoard) {
		Session session = HibernateUtil.getSession();
		session.update(messageBoard);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void save(MessageBoard messageBoard) {
		Session session = HibernateUtil.getSession();
		session.save(messageBoard);
	}
}
