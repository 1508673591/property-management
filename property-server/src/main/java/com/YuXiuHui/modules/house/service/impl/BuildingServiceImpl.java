package com.YuXiuHui.modules.house.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.YuXiuHui.modules.house.dao.BuildingDao;
import com.YuXiuHui.modules.house.entity.BuildingEntity;
import com.YuXiuHui.modules.house.service.BuildingService;



@Service("buildingService")
public class BuildingServiceImpl implements BuildingService {
	@Autowired
	private BuildingDao buildingDao;
	
	@Override
	public BuildingEntity queryObject(Integer id){
		return buildingDao.queryObject(id);
	}
	
	@Override
	public List<BuildingEntity> queryList(Map<String, Object> map){
		return buildingDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return buildingDao.queryTotal(map);
	}
	
	@Override
	public void save(BuildingEntity building){
		buildingDao.save(building);
	}
	
	@Override
	public void update(BuildingEntity building){
		buildingDao.update(building);
	}
	
	@Override
	public void delete(Integer id){
		buildingDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		buildingDao.deleteBatch(ids);
	}
	
}
