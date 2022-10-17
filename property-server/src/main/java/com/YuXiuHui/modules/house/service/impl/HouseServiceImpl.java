package com.YuXiuHui.modules.house.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.YuXiuHui.modules.house.dao.HouseDao;
import com.YuXiuHui.modules.house.entity.HouseEntity;
import com.YuXiuHui.modules.house.service.HouseService;



@Service("houseService")
public class HouseServiceImpl implements HouseService {
	@Autowired
	private HouseDao houseDao;
	
	@Override
	public HouseEntity queryObject(Integer id){
		return houseDao.queryObject(id);
	}
	
	@Override
	public List<HouseEntity> queryList(Map<String, Object> map){
		return houseDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return houseDao.queryTotal(map);
	}
	
	@Override
	public void save(HouseEntity house){
		houseDao.save(house);
	}
	
	@Override
	public void update(HouseEntity house){
		houseDao.update(house);
	}
	
	@Override
	public void delete(Integer id){
		houseDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		houseDao.deleteBatch(ids);
	}
	
}
