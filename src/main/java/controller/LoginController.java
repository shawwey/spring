package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
	
@Controller
@RequestMapping(value="")
public class LoginController {

	@RequestMapping(value="main.do")
	public String toLogin(){
		return "main";
	}
}
