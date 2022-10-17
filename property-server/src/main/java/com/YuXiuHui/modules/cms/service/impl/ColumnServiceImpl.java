package com.YuXiuHui.modules.cms.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.YuXiuHui.modules.cms.dao.ColumnDao;
import com.YuXiuHui.modules.cms.entity.ColumnEntity;
import com.YuXiuHui.modules.cms.service.ColumnService;


@Service("columnService")
public class ColumnServiceImpl implements ColumnService {
	@Autowired
	private ColumnDao columnDao;
	
	@Override
	public ColumnEntity queryObject(Integer id){
		return columnDao.queryObject(id);
	}
	
	@Override
	public List<ColumnEntity> queryList(Map<String, Object> map){
		return columnDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return columnDao.queryTotal(map);
	}
	
	@Override
	public void save(ColumnEntity column){
		columnDao.save(column);
	}
	
	@Override
	public void update(ColumnEntity column){
		columnDao.update(column);
	}
	
	@Override
	public void delete(Integer id){
		columnDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		columnDao.deleteBatch(ids);
	}
	
}
