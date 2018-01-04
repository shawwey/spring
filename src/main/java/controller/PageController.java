package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="")
public class PageController {
	
	/*
	 * 1.首页
	 */
	@RequestMapping(value="main.do")
	public String toMain(){
		return "main";
	}
	
	/*
	 * 2.文件上传
	 */	
	@RequestMapping(value="fileUpload.do")
	public String tofileUpload(){
		return "fileUpload";
	}
	
	/*
	 * 3.登录
	 */	
	@RequestMapping(value="login.do")
	public String toLogin(){
		return "login";
	}
}
