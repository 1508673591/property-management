package com.YuXiuHui.modules.property.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.YuXiuHui.modules.property.entity.PayEntity;
import com.YuXiuHui.modules.property.service.PayService;
import com.YuXiuHui.common.utils.Query;
import com.YuXiuHui.common.utils.R;




/**
 * 缴费
 * 
 * @author lizhengle
 * 
 */
@RestController
@RequestMapping("pay")
public class PayController {
	@Autowired
	private PayService payService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<PayEntity> payList = payService.queryList(query);
		int total = payService.queryTotal(query);
		
		return R.ok().put("rows", payList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		PayEntity pay = payService.queryObject(id);
		
		return R.ok().put("pay", pay);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody PayEntity pay){
		payService.save(pay);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody PayEntity pay){
		payService.update(pay);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		payService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
