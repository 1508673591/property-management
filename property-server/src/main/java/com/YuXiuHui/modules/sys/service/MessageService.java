package com.YuXiuHui.modules.sys.service;

import com.YuXiuHui.modules.sys.entity.MessageEntity;

import java.util.List;
import java.util.Map;

/**
 * 消息
 * 
 * @author lizhengle
 * 
 * @date 2020-09-24 11:15:42
 */
public interface MessageService {
	
	MessageEntity queryObject(Integer id);
	
	List<MessageEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MessageEntity message);
	
	void update(MessageEntity message);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
