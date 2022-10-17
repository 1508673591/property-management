package com.YuXiuHui.modules.property.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.YuXiuHui.modules.property.dao.PayDao;
import com.YuXiuHui.modules.property.entity.PayEntity;
import com.YuXiuHui.modules.property.service.PayService;



@Service("payService")
public class PayServiceImpl implements PayService {
	@Autowired
	private PayDao payDao;
	
	@Override
	public PayEntity queryObject(Integer id){
		return payDao.queryObject(id);
	}
	
	@Override
	public List<PayEntity> queryList(Map<String, Object> map){
		return payDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return payDao.queryTotal(map);
	}
	
	@Override
	public void save(PayEntity pay){
		payDao.save(pay);
	}
	
	@Override
	public void update(PayEntity pay){
		payDao.update(pay);
	}
	
	@Override
	public void delete(Integer id){
		payDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		payDao.deleteBatch(ids);
	}

	@Override
	public List<Map<String, String>> queryPaySum() {
		return payDao.queryPaySum();
	}
	
}
