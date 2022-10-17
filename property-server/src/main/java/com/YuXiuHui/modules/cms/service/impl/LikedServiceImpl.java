package com.YuXiuHui.modules.cms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.YuXiuHui.modules.cms.dao.LikedDao;
import com.YuXiuHui.modules.cms.entity.LikedEntity;
import com.YuXiuHui.modules.cms.service.LikedService;


@Service("likedService")
public class LikedServiceImpl implements LikedService {
	@Autowired
	private LikedDao likedDao;
	
	@Override
	public LikedEntity queryObject(Integer id){
		return likedDao.queryObject(id);
	}
	
	@Override
	public List<LikedEntity> queryList(Map<String, Object> map){
		return likedDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return likedDao.queryTotal(map);
	}
	
	@Override
	public void save(LikedEntity liked){
		likedDao.save(liked);
	}
	
	@Override
	public void update(LikedEntity liked){
		likedDao.update(liked);
	}
	
	@Override
	public void delete(Integer id){
		likedDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		likedDao.deleteBatch(ids);
	}

	@Override
	public Boolean queryLiked(Long userId, Integer articleId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", userId);
		map.put("articleId", articleId);
		int total = likedDao.queryTotal(map);
		return total > 0;
	}
	
}
