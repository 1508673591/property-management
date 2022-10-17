package com.YuXiuHui.modules.house.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.YuXiuHui.common.utils.R;
import com.YuXiuHui.modules.house.entity.HouseEntity;
import com.YuXiuHui.modules.house.service.HouseService;

@RestController
@RequestMapping("/api/house")
public class ApiHouseController {
	
	@Autowired
	private HouseService houseService;

	@RequestMapping("/list")
	public R list(@RequestAttribute Long userId, @RequestParam Map<String, Object> params) {
		params.put("memberId", userId);
		List<HouseEntity> houseList = houseService.queryList(params);
		return R.ok().put("houseList", houseList);
	}
	
	
}
