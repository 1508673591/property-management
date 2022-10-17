package com.YuXiuHui.modules.repair.api;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.YuXiuHui.common.annotation.AuthIgnore;
import com.YuXiuHui.common.utils.Query;
import com.YuXiuHui.common.utils.R;
import com.YuXiuHui.modules.repair.entity.RepairEntity;
import com.YuXiuHui.modules.repair.service.RepairService;

/**
 * 接口
 * @author GDUFSlqm
 *
 */
@RestController
@RequestMapping("/api/repair")
public class ApiRepairController {
	
	@Autowired
	private RepairService repairService;
	
	/**
	 * 查询列表
	 * @param map
	 * @return
	 */
	@AuthIgnore
	@GetMapping("list")
    public R list(@RequestParam Map<String, Object> map){
		map.put("status", 1);
		Query query = new Query(map);
    	List<RepairEntity> repairList = repairService.queryList(query);
    	Integer total = repairService.queryTotal(map);
        return R.ok().put("repairList", repairList).put("total", total);
    }
    
	/**
	 * 详情
	 * @param id
	 * @return
	 */
	@AuthIgnore
    @GetMapping("detail")
    public R detail(int id){
    	RepairEntity repair = repairService.queryObject(id);
    	return R.ok().put("repair", repair);
    }
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestAttribute("userId") Long userId, @RequestBody RepairEntity repair){
		repair.setMemberId(userId);
		repair.setStatus(1);
		repair.setCreateTime(new Date());
		repairService.save(repair);
		
		return R.ok();
	}
	
	/**
	 * 查询发布
	 * @param userId
	 * @param map
	 * @return
	 */
	@GetMapping("mine")
	public R mine(@RequestAttribute("userId") Long userId, @RequestParam Map<String, Object> map) {
		map.put("memberId", userId);
		Query query = new Query(map);
    	List<RepairEntity> repairList = repairService.queryList(query);
    	Integer total = repairService.queryTotal(map);
        return R.ok().put("repairList", repairList).put("total", total);
	}
	
}
