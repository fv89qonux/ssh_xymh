package com.my.xymh.controller.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.my.xymh.base.BaseController;
import com.my.xymh.entity.Banner;
import com.my.xymh.entity.Config;
import com.my.xymh.entity.Honor;
import com.my.xymh.entity.News;
import com.my.xymh.entity.Product;
import com.my.xymh.service.BannerService;
import com.my.xymh.service.ConfigService;
import com.my.xymh.service.HonorService;
import com.my.xymh.service.NewsService;
import com.my.xymh.service.ProductService;
import com.my.xymh.utils.Pager;

/**
 * 网站前台相关
 * @author 
 *
 */
@Controller
@RequestMapping("/web")
public class WebController extends BaseController{
	
	@Autowired
	private BannerService bannerService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private HonorService honorService;
	
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private ConfigService configService;
	
	/**
	 * 网站首页
	 * @return
	 */
	@RequestMapping(value = "/index.do")
	public String index(Model model){
		//导航图
		List<Banner> bans = bannerService.listAll();
		model.addAttribute("bans", bans);
		
		//产品列表
		List<Product> productList = productService.listAll();
		model.addAttribute("productList", productList);
		
		//资质荣誉
		List<Honor> honorList = honorService.listAll();
		model.addAttribute("honorList", honorList);
		
		//新闻资讯
		//分页查询
		News news = new News();
		Pager<News> pagers = newsService.findByEntity(news);
		model.addAttribute("pagers", pagers);
		
		List<News> newsList = newsService.listAll();
		//取前8条新闻用于首页展示
		List<News> newsList2 = new ArrayList<News>();
		for(int i = 0 ; i < 8 ; i ++){
			newsList2.add(newsList.get(i));
		}
		model.addAttribute("newsList", newsList2);
		
		//当前菜单
		model.addAttribute("current", "index");
		return "web/index";
		
	}
	
	/**
	 * 网站配置页面
	 * @return
	 */
	@RequestMapping(value = "/config.do")
	public String config(Model model){
		Config obj = configService.load("1");
		model.addAttribute("obj", obj);
		return "web/config";
	}
	
	/**
	 * 网址配置保存
	 * @return
	 */
	@RequestMapping(value = "/save.do")
	public String save(Config config, Model model, HttpServletRequest request, HttpServletResponse response) {
		configService.update(config);
		//将配置信息放入session
		request.getSession().setAttribute("config", config);
		return "redirect:/web/config.do";
	}

	/**
	 * 联系我们
	 * @return
	 */
	@RequestMapping(value = "/contact.do")
	public String contact(Model model){
		//导航图
		List<Banner> bans = bannerService.listAll();
		model.addAttribute("bans", bans);
				
		Config obj = configService.load("1");
		model.addAttribute("obj", obj);
		
		//当前菜单
		model.addAttribute("current", "contact");
		return "web/contact";
	}
}
