package com.YuXiuHui.modules.property.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.YuXiuHui.common.utils.DateUtils;
import com.YuXiuHui.common.utils.R;
import com.YuXiuHui.modules.house.service.HouseService;
import com.YuXiuHui.modules.member.service.MemberService;
import com.YuXiuHui.modules.property.service.PayService;
import com.YuXiuHui.modules.repair.service.RepairService;


/**
 * 分类
 * 
 * @author lizhengle
 * 
 */
@RestController
@RequestMapping("statistics")
public class StatisticsController {
	@Autowired
	private RepairService repairService;
	@Autowired
	private HouseService houseService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private PayService payService;
	
	/**
	 * 
	 */
	@RequestMapping("/query")
	public R query(@RequestParam Map<String, Object> params){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer userTotal = memberService.queryTotal(map);
		Integer houseTotal = houseService.queryTotal(map);
		Integer repairTotal = repairService.queryTotal(map);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("userTotal", userTotal);
		result.put("repairTotal", repairTotal);
		result.put("houseTotal", houseTotal);
		
		// 近7天缴费
		List<Map<String, String>> payCountList = payService.queryPaySum();
		List<Map<String, String>> newPayCountList = new ArrayList<>();
		if (payCountList == null || payCountList.size() < 7) {
			for (int i = -7; i < 0; i++) {
				// 补齐近7天数据，值为0
				Date now = new Date();
				Map<String, String> c = hasDate(DateUtils.format(DateUtils.add(now, i)), payCountList);
				if(c == null) {
					Map<String, String> m = new HashMap<>();
					m.put("createTime", DateUtils.format(DateUtils.add(now, i)));
					m.put("count", "0");
					newPayCountList.add(m);
				}else {
					newPayCountList.add(c);
				}
			}
			result.put("payCountList", newPayCountList);
		}else {
			result.put("payCountList", payCountList);
		}
		
		List<Map<String, Object>> repairCountList = repairService.queryCount();
		result.put("repairCountList", repairCountList);
		return R.ok().put("statistics", result);
	}
	
	private Map<String, String> hasDate(String date, List<Map<String, String>> list) {
		for (Map<String, String> map : list) {
			if(date.equals(map.get("createTime"))) {
				return map;
			}
		}
		return null;
	}
	
	
}
