package com.YuXiuHui.modules.shopping.service.impl;

import com.YuXiuHui.modules.shopping.dao.ShoppingDao;
import com.YuXiuHui.modules.shopping.entity.ShoppingEntity;
import com.YuXiuHui.modules.shopping.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("ShoppingService")
public class ShoppingServiceImpl implements ShoppingService {
	@Autowired
	private ShoppingDao shoppingDao;
	
	@Override
	public ShoppingEntity queryObject(Integer id){
		return shoppingDao.queryObject(id);
	}
	
	@Override
	public List<ShoppingEntity> queryList(Map<String, Object> map){
		return shoppingDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return shoppingDao.queryTotal(map);
	}
	
	@Override
	public void save(ShoppingEntity shopping){
		shoppingDao.save(shopping);
	}
	
	@Override
	public void update(ShoppingEntity shopping){
		shoppingDao.update(shopping);
	}
	
	@Override
	public void delete(Integer id){
		shoppingDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		shoppingDao.deleteBatch(ids);
	}
	
}
