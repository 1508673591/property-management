package com.YuXiuHui.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.YuXiuHui.modules.member.dao.MemberDao;
import com.YuXiuHui.modules.member.entity.MemberEntity;
import com.YuXiuHui.modules.sys.dao.MessageDao;
import com.YuXiuHui.modules.sys.entity.MessageEntity;
import com.YuXiuHui.modules.sys.service.MessageService;


@Service("messageService")
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageDao messageDao;
	@Autowired
	private MemberDao userDao;
	
	@Override
	public MessageEntity queryObject(Integer id){
		return messageDao.queryObject(id);
	}
	
	@Override
	public List<MessageEntity> queryList(Map<String, Object> map){
		return messageDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return messageDao.queryTotal(map);
	}
	
	@Override
	public void save(MessageEntity message){
		if(message.getUserId() == null) {
			List<MemberEntity> userList = userDao.queryList(null);
			for (MemberEntity user : userList) {
				message.setUserId(user.getId());
				messageDao.save(message);
			}
		}else {
			messageDao.save(message);
		}
	}
	
	@Override
	public void update(MessageEntity message){
		messageDao.update(message);
	}
	
	@Override
	public void delete(Integer id){
		messageDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		messageDao.deleteBatch(ids);
	}
	
}
