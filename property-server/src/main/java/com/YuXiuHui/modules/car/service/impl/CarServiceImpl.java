package com.YuXiuHui.modules.car.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.YuXiuHui.modules.car.dao.CarDao;
import com.YuXiuHui.modules.car.entity.CarEntity;
import com.YuXiuHui.modules.car.service.CarService;



@Service("carService")
public class CarServiceImpl implements CarService {
	@Autowired
	private CarDao carDao;
	
	@Override
	public CarEntity queryObject(Integer id){
		return carDao.queryObject(id);
	}
	
	@Override
	public List<CarEntity> queryList(Map<String, Object> map){
		return carDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return carDao.queryTotal(map);
	}
	
	@Override
	public void save(CarEntity car){
		carDao.save(car);
	}
	
	@Override
	public void update(CarEntity car){
		carDao.update(car);
	}
	
	@Override
	public void delete(Integer id){
		carDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		carDao.deleteBatch(ids);
	}
	
}
