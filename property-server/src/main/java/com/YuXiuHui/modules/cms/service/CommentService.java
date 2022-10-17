package com.YuXiuHui.modules.cms.service;

import java.util.List;
import java.util.Map;

import com.YuXiuHui.modules.cms.entity.CommentEntity;

/**
 * 
 * @author lizhengle
 * @email 123456789@qq.com
 */
public interface CommentService {
	
	CommentEntity queryObject(Integer id);
	
	List<CommentEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CommentEntity comment);
	
	void update(CommentEntity comment);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
