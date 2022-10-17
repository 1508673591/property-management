package com.YuXiuHui.modules.cms.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.YuXiuHui.modules.cms.entity.LikedEntity;
import com.YuXiuHui.modules.sys.dao.BaseDao;

/**
 * 
 * @author lizhengle
 * @email 123456789@qq.com
 */
@Mapper
public interface LikedDao extends BaseDao<LikedEntity> {

	void deleteByArticleId(@Param("articleId")Integer articleId, @Param("memberId")Long memberId);
	
}
