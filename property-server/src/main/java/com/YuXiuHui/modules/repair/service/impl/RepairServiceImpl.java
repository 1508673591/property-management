package com.YuXiuHui.modules.repair.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.YuXiuHui.modules.repair.dao.RepairDao;
import com.YuXiuHui.modules.repair.dao.RepairPicDao;
import com.YuXiuHui.modules.repair.entity.RepairEntity;
import com.YuXiuHui.modules.repair.entity.RepairPicEntity;
import com.YuXiuHui.modules.repair.service.RepairService;

@Service("repairService")
public class RepairServiceImpl implements RepairService {
	@Autowired
	private RepairDao repairDao;
	@Autowired
	private RepairPicDao repairPicDao;
	
	@Override
	public RepairEntity queryObject(Integer id){
		RepairEntity repair = repairDao.queryObject(id);
		repair.setPicUrls(repairPicDao.queryByRepairId(id));
		return repair;
	}
	
	@Override
	public List<RepairEntity> queryList(Map<String, Object> map){
		return repairDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return repairDao.queryTotal(map);
	}
	
	@Override
	@Transactional
	public void save(RepairEntity repair){
		repairDao.save(repair);
		if (repair.getPicUrls() != null) {
			String[] picUrls = repair.getPicUrls();
			for (String picUrl : picUrls) {
				RepairPicEntity repairPic = new RepairPicEntity();
				repairPic.setRepairId(repair.getId());
				repairPic.setPicUrl(picUrl);
				repairPicDao.save(repairPic);
			}
		}
	}
	
	@Override
	public void update(RepairEntity repair){
		repairDao.update(repair);
	}
	
	@Override
	public void delete(Integer id){
		repairDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		repairDao.deleteBatch(ids);
	}

	@Override
	public void complete(Integer[] ids) {
		for (Integer id : ids) {
			RepairEntity repair = new RepairEntity();
			repair.setId(id);
			repair.setStatus(2);
			repairDao.update(repair);
		}
	}

	@Override
	public List<Map<String, Object>> queryCount() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", 1);
		Integer ucount = repairDao.queryTotal(params);
		params.put("status", 2);
		Integer icount = repairDao.queryTotal(params);
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Map<String, Object> u = new HashMap<String, Object>();
		u.put("count", ucount);
		u.put("name", "待维修");
		result.add(u);
		
		Map<String, Object> i = new HashMap<String, Object>();
		i.put("count", icount);
		i.put("name", "已维修");
		result.add(i);
		return result;
	}
	
}
