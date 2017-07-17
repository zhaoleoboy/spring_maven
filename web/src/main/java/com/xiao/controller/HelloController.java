package com.xiao.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xiao.common.RandomValidateCode;
import com.xiao.model.User;
import com.xiao.service.IUserService;

@Controller
@RequestMapping("/user")
public class HelloController {

	@RequestMapping("hello")
	public @ResponseBody String hello() {
		return "hello, world";
	}

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/getUser")
	public @ResponseBody String getUser() {
		User user = userService.listUsers(new Long(123));
		return user.getUsername();
	}

	/**
	 * 跳转到登录页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/main")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

	// 登录获取验证码
	@RequestMapping("/getSysManageLoginCode")
	@ResponseBody
	public String getSysManageLoginCode(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("image/jpeg");// 设置相应类型,告诉浏览器输出的内容为图片
		response.setHeader("Pragma", "No-cache");// 设置响应头信息，告诉浏览器不要缓存此内容
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Set-Cookie", "name=value; HttpOnly");// 设置HttpOnly属性,防止Xss攻击
		response.setDateHeader("Expire", 0);
		RandomValidateCode randomValidateCode = new RandomValidateCode();
		try {
			randomValidateCode.getRandcode(request, response, "_code");// 输出图片方法
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 主页的的登陆
	 * 
	 * @param username
	 * @param password
	 * @param vcode
	 * @param rememberMe
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "ajaxLogin", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> submitLogin(String username, String password, String vcode, Boolean rememberMe,
			Model model) {
		Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
		if (vcode == null || vcode == "") {
			resultMap.put("status", 500);
			resultMap.put("message", "验证码不能为空！");
			return resultMap;
		}

		Session session = SecurityUtils.getSubject().getSession();
		// 转化成小写字母
		vcode = vcode.toLowerCase();
		String v = (String) session.getAttribute("_code");
		// 还可以读取一次后把验证码清空，这样每次登录都必须获取验证码
		// session.removeAttribute("_come");
		if (!vcode.equalsIgnoreCase(v)) {
			resultMap.put("status", 500);
			resultMap.put("message", "验证码错误！");
			return resultMap;
		}

		try {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
			SecurityUtils.getSubject().login(token);
			resultMap.put("status", 200);
			resultMap.put("message", "登录成功");
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", e.getMessage());
		}
		return resultMap;
	}

}