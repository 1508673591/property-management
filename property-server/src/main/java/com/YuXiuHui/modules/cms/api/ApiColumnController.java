package com.YuXiuHui.modules.cms.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.YuXiuHui.common.annotation.AuthIgnore;
import com.YuXiuHui.common.utils.R;
import com.YuXiuHui.modules.cms.entity.ColumnEntity;
import com.YuXiuHui.modules.cms.service.ColumnService;

@RestController
@RequestMapping("/api/column")
public class ApiColumnController {
	
	@Autowired
	private ColumnService columnService;

	@AuthIgnore
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {
		params.put("sidx", "sort");
		params.put("order", "asc");
		params.put("status", 1);
		List<ColumnEntity> columnList = columnService.queryList(params);
		if(columnList != null && columnList.size() != 0 && params.get("parentId") == null) {
			for (ColumnEntity column : columnList) {
				params.put("parentId", column.getId());
				List<ColumnEntity> children = columnService.queryList(params);
				column.setChildren(children);
			}
		}
		
		return R.ok().put("columnList", columnList);
	}
	
	
}
