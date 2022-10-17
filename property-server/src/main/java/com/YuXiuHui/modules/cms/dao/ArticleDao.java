package com.YuXiuHui.modules.cms.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.YuXiuHui.modules.cms.entity.ArticleEntity;
import com.YuXiuHui.modules.sys.dao.BaseDao;

/**
 * 
 *
 */
@Mapper
public interface ArticleDao extends BaseDao<ArticleEntity> {

	ArticleEntity queryOneByColumnId(Integer columnId);

	ArticleEntity queryOneByColumnCode(@Param("columnCode")String columnCode, @Param("storeId")Long storeId);
	
}
