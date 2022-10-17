package com.YuXiuHui.modules.car.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.YuXiuHui.common.utils.R;
import com.YuXiuHui.modules.car.entity.CarEntity;
import com.YuXiuHui.modules.car.service.CarService;

@RestController
@RequestMapping("/api/car")
public class ApiCarController {
	
	@Autowired
	private CarService carService;

	@RequestMapping("/list")
	public R list(@RequestAttribute Long userId, @RequestParam Map<String, Object> params) {
		params.put("memberId", userId);
		List<CarEntity> carList = carService.queryList(params);
		return R.ok().put("carList", carList);
	}
	
	
}
