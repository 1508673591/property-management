package com.YuXiuHui.modules.car.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.YuXiuHui.modules.car.entity.ParkingEntity;
import com.YuXiuHui.modules.car.service.ParkingService;
import com.YuXiuHui.common.utils.Query;
import com.YuXiuHui.common.utils.R;




/**
 * 车位
 * 
 * @author lizhengle
 * 
 */
@RestController
@RequestMapping("parking")
public class ParkingController {
	@Autowired
	private ParkingService parkingService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ParkingEntity> parkingList = parkingService.queryList(query);
		int total = parkingService.queryTotal(query);
		
		return R.ok().put("rows", parkingList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		ParkingEntity parking = parkingService.queryObject(id);
		
		return R.ok().put("parking", parking);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody ParkingEntity parking){
		parking.setCreateTime(new Date());
		parkingService.save(parking);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody ParkingEntity parking){
		parkingService.update(parking);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		parkingService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
