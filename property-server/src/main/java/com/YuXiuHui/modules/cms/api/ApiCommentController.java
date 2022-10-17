package com.YuXiuHui.modules.cms.api;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.YuXiuHui.common.annotation.AuthIgnore;
import com.YuXiuHui.common.utils.R;
import com.YuXiuHui.modules.cms.entity.CommentEntity;
import com.YuXiuHui.modules.cms.service.CommentService;

@RestController
@RequestMapping("/api/comment")
public class ApiCommentController {
	
	@Autowired
	private CommentService commentService;

	@AuthIgnore
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {
		List<CommentEntity> commentList = commentService.queryList(params);
		Integer total = commentService.queryTotal(params);
		return R.ok().put("commentList", commentList).put("total", total);
	}
	
	@RequestMapping("/save")
	public R comment(@RequestBody CommentEntity comment, @RequestAttribute Long userId) {
		comment.setCreateTime(new Date());
		comment.setMemberId(userId);
		commentService.save(comment);
		return R.ok();
	}
}
