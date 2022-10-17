package com.YuXiuHui.modules.sys.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.YuXiuHui.modules.sys.entity.MessageEntity;
import com.YuXiuHui.modules.sys.service.MessageService;
import com.YuXiuHui.common.utils.Query;
import com.YuXiuHui.common.utils.R;


/**
 * 消息
 * 
 * @author lizhengle
 * 
 */
@RestController
@RequestMapping("message")
public class MessageController {
	@Autowired
	private MessageService messageService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<MessageEntity> messageList = messageService.queryList(query);
		int total = messageService.queryTotal(query);
		
		return R.ok().put("rows", messageList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		MessageEntity message = messageService.queryObject(id);
		
		return R.ok().put("message", message);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody MessageEntity message){
		message.setCreateTime(new Date());
		message.setStatus(0);
		messageService.save(message);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody MessageEntity message){
		messageService.update(message);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		messageService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
