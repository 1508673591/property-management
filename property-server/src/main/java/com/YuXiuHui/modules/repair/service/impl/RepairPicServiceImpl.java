package com.YuXiuHui.modules.repair.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.YuXiuHui.modules.repair.dao.RepairPicDao;
import com.YuXiuHui.modules.repair.entity.RepairPicEntity;
import com.YuXiuHui.modules.repair.service.RepairPicService;



@Service("repairPicService")
public class RepairPicServiceImpl implements RepairPicService {
	@Autowired
	private RepairPicDao repairPicDao;
	
	@Override
	public RepairPicEntity queryObject(Integer id){
		return repairPicDao.queryObject(id);
	}
	
	@Override
	public List<RepairPicEntity> queryList(Map<String, Object> map){
		return repairPicDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return repairPicDao.queryTotal(map);
	}
	
	@Override
	public void save(RepairPicEntity repairPic){
		repairPicDao.save(repairPic);
	}
	
	@Override
	public void update(RepairPicEntity repairPic){
		repairPicDao.update(repairPic);
	}
	
	@Override
	public void delete(Integer id){
		repairPicDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		repairPicDao.deleteBatch(ids);
	}
	
}
