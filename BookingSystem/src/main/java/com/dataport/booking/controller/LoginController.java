package com.dataport.booking.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dataport.booking.entity.User;
import com.dataport.booking.service.UserService;
/**
 * 
 * <p>Class       : com.dataport.booking.controller.LoginController
 * <p>Descdription: user状态为0为管理员登录，状态为1为员工登录，状态为2为账号或者密码错误
 *
 * @author  XX XX@dataport.com.cn
 * @version 1.0.0
 *<p>
 *--------------------------------------------------------------<br>
 * 修改履历：<br>
 *        <li> 2019年7月23日，XX@dataport.com.cn，创建文件；<br>
 *--------------------------------------------------------------<br>
 *</p>
 */
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	UserService userService;
	@Autowired
	private HttpSession httpSession;
	@PostMapping("/doLogin")
	public String doLogin(@RequestParam String userAccount,@RequestParam String password) {
		//System.out.println("测试zjw");
		User user = userService.findByAccount(userAccount);
		if (user!=null) {
			if (user.getPassword().equals(password)) {
				if(user.getState()==0) {
					httpSession.setAttribute("user", user);
					return "0";
				}else {
					httpSession.setAttribute("user", user);
					return "1";
					}
			}else {
				return "2";
			}
		}
		return "2";
	}

}