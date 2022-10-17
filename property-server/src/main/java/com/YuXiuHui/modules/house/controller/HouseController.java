package com.YuXiuHui.modules.house.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.YuXiuHui.modules.house.entity.HouseEntity;
import com.YuXiuHui.modules.house.service.HouseService;
import com.YuXiuHui.common.utils.Query;
import com.YuXiuHui.common.utils.R;




/**
 * 房屋
 * 
 * @author lizhengle
 * 
 */
@RestController
@RequestMapping("house")
public class HouseController {
	@Autowired
	private HouseService houseService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<HouseEntity> houseList = houseService.queryList(query);
		int total = houseService.queryTotal(query);
		
		return R.ok().put("rows", houseList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		HouseEntity house = houseService.queryObject(id);
		
		return R.ok().put("house", house);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody HouseEntity house){
		house.setCreateTime(new Date());
		houseService.save(house);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody HouseEntity house){
		houseService.update(house);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		houseService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
