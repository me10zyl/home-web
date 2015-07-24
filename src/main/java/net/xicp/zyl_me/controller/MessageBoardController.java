package net.xicp.zyl_me.controller;

import java.util.Collections;
import java.util.List;

import net.xicp.zyl_me.bal.entity.Status;
import net.xicp.zyl_me.dal.dao.MessageBoardDAO;
import net.xicp.zyl_me.dal.entity.MessageBoard;

import org.codehaus.jackson.map.annotate.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messageBoard")
public class MessageBoardController {
	@Autowired
	private MessageBoardDAO messageBoardDAO;

	@RequestMapping(value = "/page/{page}", method = RequestMethod.GET)
	public List<MessageBoard> getMessageBoardByPage(@PathVariable("page") int currentPage) {
		List<MessageBoard> messageBoards = messageBoardDAO.listByPage(currentPage);
//		Collections.reverse(messageBoards);
	/*	for (int i = 0; i < messageBoards.size() / 2; i++) {
			MessageBoard tmp;
			tmp = messageBoards.get(i);
			messageBoards.set(i, messageBoards.get(messageBoards.size() - 1 - i));
			messageBoards.set(messageBoards.size() - 1 - i, tmp);
		}*/
		return messageBoards;
	}

	private MessageBoard oldMessageBoard;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Status saveMessageBoard(@RequestBody MessageBoard messageBoard) {
		Status status = new Status();
		status.setSuccess(false);
		if (messageBoard.getName() == null || messageBoard.getName().equals("")) {
			status.setMessage("用户名为空");
			return status;
		} else if (messageBoard.getContent() == null || messageBoard.getContent().equals("")) {
			status.setMessage("留言内容为空");
			return status;
		} else if (oldMessageBoard != null && messageBoard.equals(oldMessageBoard)) {
			status.setMessage("处理中, 请不要重复提交");
			return status;
		}
		oldMessageBoard = messageBoard;
		try {
			messageBoardDAO.save(messageBoard);
			status.setMessage("留言成功");
			status.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			status.setSuccess(false);
			status.setMessage("留言失败:" + e.getMessage());
			e.printStackTrace();
		}
		return status;
	}
}
