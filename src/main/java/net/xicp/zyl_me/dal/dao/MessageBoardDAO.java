package net.xicp.zyl_me.dal.dao;

import java.util.ArrayList;
import java.util.List;

import net.xicp.zyl_me.dal.entity.MessageBoard;
import net.xicp.zyl_me.util.HibernateUtil;
import net.xicp.zyl_me.util.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Repository
public class MessageBoardDAO extends DataAccessObject<MessageBoard> {
	private Session getSession() {
		return HibernateUtil.getSession();
	}

	private SqlSession getSqlSession() {
		return MyBatisUtil.getSqlSession();
	}

	@Override
	public MessageBoard findById(int id) {
		Session session = HibernateUtil.getSession();
		MessageBoard messageBoard = (MessageBoard) session.get(MessageBoard.class, id);
		return messageBoard;
	}

	@Override
	public List<MessageBoard> list() {
		List<MessageBoard> messageBoards = new ArrayList<MessageBoard>();
		SqlSession sqlSession = getSqlSession();
		messageBoards = sqlSession.selectList("selectMessaBoradAll");
		return messageBoards;
	}

	@SuppressWarnings("unchecked")
	public List<MessageBoard> listByPage(int currentPage) {
		List<MessageBoard> messageBoards = new ArrayList<MessageBoard>();
		Session session = getSession();
		Query query = session.createQuery("from MessageBoard order by id desc");
//		int endIndex = currentPage * Page.pageSize;
//		Integer maxResults = getTotalCount();
		query.setMaxResults(Page.pageSize);
		int startIndex = (currentPage - 1) * Page.pageSize;
		query.setFirstResult(startIndex < 0 ? 0 : startIndex);
		return query.list();
	}

	public int getTotalPage() {
		int totalCount = getTotalCount();
		int totalPage = totalCount % Page.pageSize == 0 ? totalCount / Page.pageSize : totalCount / Page.pageSize + 1;
		return totalPage;
	}

	public int getTotalCount(){
		SqlSession sqlSession = getSqlSession();
		Integer count = sqlSession.selectOne("selectMessageBoardCount");
		return count;
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
