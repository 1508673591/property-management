package com.YuXiuHui.modules.shopping.controller;

import com.YuXiuHui.common.utils.Query;
import com.YuXiuHui.common.utils.R;
import com.YuXiuHui.modules.shopping.entity.ShoppingEntity;
import com.YuXiuHui.modules.shopping.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 商品
 *
 * 
 */
@RestController
@RequestMapping("shopping")
public class ShoppingController {
	@Autowired
	private ShoppingService shoppingService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ShoppingEntity> shoppingList = shoppingService.queryList(query);
		int total = shoppingService.queryTotal(query);

		return R.ok().put("rows", shoppingList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info")
	public R info(@RequestParam Map<String, Object> params){
		int id = Integer.valueOf((String) params.get("id")) ;
		ShoppingEntity shopping = shoppingService.queryObject(id);
		
		return R.ok().put("shopping", shopping);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody ShoppingEntity shopping){
		shopping.setCreateTime(new Date());
		shoppingService.save(shopping);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody ShoppingEntity shopping){
		shoppingService.update(shopping);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		shoppingService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
