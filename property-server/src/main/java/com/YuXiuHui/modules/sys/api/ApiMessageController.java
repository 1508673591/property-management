package com.YuXiuHui.modules.sys.api;

import com.YuXiuHui.common.annotation.AuthIgnore;
import com.YuXiuHui.common.utils.R;
import com.YuXiuHui.modules.sys.entity.MessageEntity;
import com.YuXiuHui.modules.sys.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 消息
 * 
 * @author GDUFSlqm
 * 
 */
@RestController
@RequestMapping("/api/message")
public class ApiMessageController {
	
	@Autowired
	private MessageService messageService;

	@GetMapping("list")
	public R list(@RequestParam Map<String, Object> params, @RequestAttribute Long userId) {
		params.put("userId", userId);
		List<MessageEntity> messageList = messageService.queryList(params);
		return R.ok().put("messageList", messageList);
	}
	
	@GetMapping("totalMsg")
	public R totalMsg(@RequestParam Map<String, Object> params,@RequestAttribute Long userId) {
		params.put("userId", userId);
		Integer totalMsg = messageService.queryTotal(params);
		return R.ok().put("totalMsg", totalMsg);
	}
	
	@AuthIgnore
	@GetMapping("detail")
    public R detail(Integer id){
		MessageEntity message = messageService.queryObject(id);
		MessageEntity msg = new MessageEntity();
		msg.setId(id);
		msg.setStatus(1);
		messageService.update(msg);
		return R.ok().put("message", message);
    }
	
}
