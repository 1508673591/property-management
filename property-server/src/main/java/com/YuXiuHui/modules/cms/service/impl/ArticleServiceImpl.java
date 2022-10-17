package com.YuXiuHui.modules.cms.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.YuXiuHui.modules.cms.dao.ArticleDao;
import com.YuXiuHui.modules.cms.dao.CommentDao;
import com.YuXiuHui.modules.cms.dao.LikedDao;
import com.YuXiuHui.modules.cms.entity.ArticleEntity;
import com.YuXiuHui.modules.cms.entity.CommentEntity;
import com.YuXiuHui.modules.cms.entity.LikedEntity;
import com.YuXiuHui.modules.cms.service.ArticleService;


@Service("artilcleService")
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao artilcleDao;
	
	@Autowired
	private LikedDao likedDao;
	
	@Autowired
	private CommentDao commentDao;
	
	@Override
	public ArticleEntity queryObject(Integer id){
		return artilcleDao.queryObject(id);
	}
	
	@Override
	public List<ArticleEntity> queryList(Map<String, Object> map){
		return artilcleDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return artilcleDao.queryTotal(map);
	}
	
	@Override
	public void save(ArticleEntity artilcle){
		artilcleDao.save(artilcle);
	}
	
	@Override
	public void update(ArticleEntity artilcle){
		artilcleDao.update(artilcle);
	}
	
	@Override
	public void delete(Integer id){
		artilcleDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		artilcleDao.deleteBatch(ids);
	}

	@Override
	public void liked(Integer articleId, Long userId) {
		LikedEntity liked = new LikedEntity();
		liked.setArticleId(articleId);
		liked.setCreateTime(new Date());
		liked.setMemberId(userId);
		likedDao.save(liked);
	}

	@Override
	public void comment(Integer articleId, Long userId, String content) {
		CommentEntity commentEntity = new CommentEntity();
		commentEntity.setArticleId(articleId);
		commentEntity.setContent(content);
		commentEntity.setMemberId(userId);
		commentEntity.setCreateTime(new Date());
		commentDao.save(commentEntity);
	}

	@Override
	public void unliked(Integer articleId, Long userId) {
		likedDao.deleteByArticleId(articleId, userId);
	}

	@Override
	public ArticleEntity queryOneByColumnId(Integer columnId) {
		return artilcleDao.queryOneByColumnId(columnId);
	}

	@Override
	public ArticleEntity queryOneByColumnCode(String columnCode, Long storeId) {
		return artilcleDao.queryOneByColumnCode(columnCode, storeId);
	}
	
}
