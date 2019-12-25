package com.lsp.springbootmybatisdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	// 403权限不足页面
	@RequestMapping("/error/403")
	public String error403() {
		return "/error/403";
	}

	// 404路径
	@RequestMapping("/error/404")
	public String error404() {
		return "/error/404";
	}

	// 500路径
	@RequestMapping("/error/500")
	public String error500() {
		return "/error/500";
	}
}
