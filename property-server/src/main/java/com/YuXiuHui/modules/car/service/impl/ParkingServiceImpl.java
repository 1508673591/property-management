package com.YuXiuHui.modules.car.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.YuXiuHui.modules.car.dao.ParkingDao;
import com.YuXiuHui.modules.car.entity.ParkingEntity;
import com.YuXiuHui.modules.car.service.ParkingService;



@Service("parkingService")
public class ParkingServiceImpl implements ParkingService {
	@Autowired
	private ParkingDao parkingDao;
	
	@Override
	public ParkingEntity queryObject(Integer id){
		return parkingDao.queryObject(id);
	}
	
	@Override
	public List<ParkingEntity> queryList(Map<String, Object> map){
		return parkingDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return parkingDao.queryTotal(map);
	}
	
	@Override
	public void save(ParkingEntity parking){
		parkingDao.save(parking);
	}
	
	@Override
	public void update(ParkingEntity parking){
		parkingDao.update(parking);
	}
	
	@Override
	public void delete(Integer id){
		parkingDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		parkingDao.deleteBatch(ids);
	}
	
}
