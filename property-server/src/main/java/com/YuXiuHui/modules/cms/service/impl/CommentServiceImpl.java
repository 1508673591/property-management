package com.YuXiuHui.modules.cms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.YuXiuHui.modules.cms.dao.CommentDao;
import com.YuXiuHui.modules.cms.entity.CommentEntity;
import com.YuXiuHui.modules.cms.service.CommentService;


@Service("commentService")
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDao commentDao;
	
	@Override
	public CommentEntity queryObject(Integer id){
		return commentDao.queryObject(id);
	}
	
	@Override
	public List<CommentEntity> queryList(Map<String, Object> map){
		return commentDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return commentDao.queryTotal(map);
	}
	
	@Override
	public void save(CommentEntity comment){
		commentDao.save(comment);
	}
	
	@Override
	public void update(CommentEntity comment){
		commentDao.update(comment);
	}
	
	@Override
	public void delete(Integer id){
		commentDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		commentDao.deleteBatch(ids);
	}
	
}
