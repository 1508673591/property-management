package com.YuXiuHui.modules.goodsPay.service.impl;

import com.YuXiuHui.modules.goodsPay.dao.GoodsPayDao;
import com.YuXiuHui.modules.goodsPay.entity.GoodsPayEntity;
import com.YuXiuHui.modules.goodsPay.service.GoodsPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("GoodsPayService")
public class GoodsPayServiceImpl implements GoodsPayService {
	
	@Autowired
	private GoodsPayDao goodsPayDao;
	
	@Override
	public GoodsPayEntity queryObject(Long id){
		return goodsPayDao.queryObject(id);
	}
	
	@Override
	public List<GoodsPayEntity> queryList(Map<String, Object> map){
		return goodsPayDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return goodsPayDao.queryTotal(map);
	}
	
	@Override
	public void save(GoodsPayEntity goodsPay){
		goodsPayDao.save(goodsPay);
	}
	
	@Override
	public void update(GoodsPayEntity goodsPay){
		goodsPayDao.update(goodsPay);
	}
	
	@Override
	public void delete(Long id){
		goodsPayDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		goodsPayDao.deleteBatch(ids);
	}


}
