package com.YuXiuHui.modules.cms.service;

import java.util.List;
import java.util.Map;

import com.YuXiuHui.modules.cms.entity.LikedEntity;

/**
 * 
 * @author lizhengle
 * @email 123456789@qq.com
 */
public interface LikedService {
	
	LikedEntity queryObject(Integer id);
	
	List<LikedEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(LikedEntity liked);
	
	void update(LikedEntity liked);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	Boolean queryLiked(Long userId, Integer articleId);
}
