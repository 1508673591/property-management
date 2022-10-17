package com.YuXiuHui.modules.cms.service;

import java.util.List;
import java.util.Map;

import com.YuXiuHui.modules.cms.entity.ArticleEntity;

/**
 * 
 * @author lizhengle
 * @email 123456789@qq.com
 */
public interface ArticleService {
	
	ArticleEntity queryObject(Integer id);
	
	List<ArticleEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ArticleEntity artilcle);
	
	void update(ArticleEntity artilcle);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	void liked(Integer id, Long userId);

	void comment(Integer id, Long userId, String comment);

	void unliked(Integer articleId, Long userId);

	ArticleEntity queryOneByColumnId(Integer columnId);

	ArticleEntity queryOneByColumnCode(String columnCode, Long storeId);
}
