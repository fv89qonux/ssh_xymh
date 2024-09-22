package com.my.xymh.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.my.xymh.base.BaseController;
import com.my.xymh.entity.Manage;
import com.my.xymh.service.ManageService;
import com.my.xymh.service.NewsService;

/**
 * 登陆相关
 * @author 
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	private ManageService manageService;
	@Autowired
	private NewsService newsService;
	
	/**
	 * 跳转登陆
	 * @return
	 */
	@RequestMapping(value = "/login.do")
	public String login(){
		return "login/login";
		
	}
	
	@RequestMapping(value = "/welcome.do")
	public String welcome(){
		return "login/welcome";
		
	}
	@RequestMapping(value = "/toLogin.do")
	public String findByObj(String userName,String passWord, Model model, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		 
		session.removeAttribute("user");
		session.removeAttribute("userId");
		Manage manage = new Manage();
		manage.setUserName(userName);
		manage.setPassWord(passWord);
		//管理员账号密码：admin
		if(userName.equals("admin") && passWord.equals("admin")){
			request.getSession().setAttribute("isManage", 1);
			return "login/mIndex";
		}else{
			return "login/login";
		}
	}
	
	/**
	 * 退出
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/tuichu.do")
	  public String tuichu(HttpSession session){
        session.invalidate();
        return "login/login";
    }
	
	@RequestMapping(value = "/utu.do")
	  public String utu(HttpSession session){
      session.invalidate();
      return "redirect:/login/index.do";
  }
	

}
