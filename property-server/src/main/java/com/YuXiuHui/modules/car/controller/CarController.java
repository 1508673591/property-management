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

import com.YuXiuHui.modules.car.entity.CarEntity;
import com.YuXiuHui.modules.car.service.CarService;
import com.YuXiuHui.common.utils.Query;
import com.YuXiuHui.common.utils.R;




/**
 * 车俩
 * 
 * @author lizhengle
 * 
 */
@RestController
@RequestMapping("car")
public class CarController {
	@Autowired
	private CarService carService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<CarEntity> carList = carService.queryList(query);
		int total = carService.queryTotal(query);
		
		return R.ok().put("rows", carList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		CarEntity car = carService.queryObject(id);
		
		return R.ok().put("car", car);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody CarEntity car){
		car.setCreateTime(new Date());
		carService.save(car);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody CarEntity car){
		carService.update(car);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		carService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
