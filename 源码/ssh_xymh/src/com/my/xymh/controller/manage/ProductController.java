package com.my.xymh.controller.manage;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.my.xymh.base.BaseController;
import com.my.xymh.utils.JsonUtil2;
import com.my.xymh.utils.Pager;
import net.sf.json.JSONObject;
import java.util.*;
import com.my.xymh.entity.*;
import com.my.xymh.dao.*;
import com.my.xymh.service.*;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年02月18日 12时25分56秒
 */


@Controller
@RequestMapping("/product")
public class ProductController extends BaseController {
	
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProTypeService proTypeService;
	
	@Autowired
	private BannerService bannerService;
	// --------------------------------------- 华丽分割线 ------------------------------
	
	/**
	 * 分页查询 返回list对象(通过对象)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/findByObj.do")
	public String findByObj(Product product, Model model, HttpServletRequest request, HttpServletResponse response) {
		//分页查询
		Pager<Product> pagers = productService.findByEntity(product);
		List<Product> list = pagers.getDatas();
		//循环查询产品类型
		for(Product pro : list){
			ProType p = proTypeService.load(pro.getType());
			if(p != null){
				pro.setTypeName(p.getTitle());
			}
		}
		pagers.setDatas(list);
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", product);
		return "product/product";
	}
	
	/**
	 * 网站前端产品列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/products.do")
	public String products(Product product, Model model, Integer type, HttpServletRequest request, HttpServletResponse response) {
		//分页查询
		product.setType(type);
		Pager<Product> pagers = productService.findByEntity(product);
		
/*		List<Product> list = pagers.getDatas();
		//循环查询产品类型
		for(Product pro : list){
			ProType p = proTypeService.load(pro.getType());
			if(p != null){
				pro.setTypeName(p.getTitle());
			}
		}
		pagers.setDatas(list);*/
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", product);
		
		//导航图
		List<Banner> bans = bannerService.listAll();
		model.addAttribute("bans", bans);
				
		//产品类型
		List<ProType> typeList = proTypeService.listAll();
		model.addAttribute("typeList", typeList);
		
		//当前菜单
		model.addAttribute("current", "product");
		//当前类型
		model.addAttribute("type", type);
		
		return "web/product_list";
	}
	
	//新闻详情
	@RequestMapping(value = "/detail.do")
	public String detail(Integer id,Model model) {
		//导航图
		List<Banner> bans = bannerService.listAll();
		model.addAttribute("bans", bans);
		
		Product obj = productService.load(id);
		model.addAttribute("obj",obj);
		
		//产品类型
		List<ProType> typeList = proTypeService.listAll();
		model.addAttribute("typeList", typeList);
				
		//当前菜单
		model.addAttribute("current", "news");
		model.addAttribute("type", obj.getType());
		return "web/product_info";
	}
		
	/**
	 * 分页查询 返回list对象(通过Map)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/findByMap.do")
	public String findByMap(Product product, Model model, HttpServletRequest request, HttpServletResponse response) {
		//通过map查询
		Map<String,Object> params = new HashMap<String,Object>();
        if(!isEmpty(product.getContent())){
        	params.put("content", product.getContent());
		}
        if(!isEmpty(product.getAddTime())){
        	params.put("addTime", product.getAddTime());
		}
        /*if(!isEmpty(product.getAddUserId())){
        	params.put("addUserId", product.getAddUserId());
		}*/
		//分页查询
		Pager<Product> pagers = productService.findByMap(params);
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", product);
		return "product/product";
	}
	
	
	/**
	 * 跳至添加页面
	 * @return
	 */
	@RequestMapping(value = "/add.do")
	public String add(Model model) {
		List<ProType> typeList = proTypeService.listAll();
		model.addAttribute("typeList", typeList);
		return "product/add";
	}

	
	/**
	 * 添加执行
	 * @return
	 */
    @RequestMapping(value = "/exAdd.do")
    public String manageMain(@RequestParam(value = "file", required = false) MultipartFile file,Product product,Integer id,Integer type, HttpServletRequest request){
    	 if(!file.isEmpty()){
	    	 System.out.println("开始");  
	    	    // String path = request.getRealPath("/upload");
	    	     String path =  request.getSession().getServletContext().getRealPath("/")+"upload/";
		        //String path = request.getSession().getServletContext().getRealPath("/upload");  
		        String fileName = file.getOriginalFilename();  
		        System.out.println(path);  
		        File targetFile = new File(Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(0,Thread.currentThread().getContextClassLoader().getResource("").getPath().length()-16)+"/upload", fileName);  
		        if(!targetFile.exists()){  
		            targetFile.mkdirs();  
		        }  
		        product.setImage("/upload/" + fileName);
		        //保存  
		        try {  
		            file.transferTo(targetFile);  
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
	     }
    	 product.setType(type);
    	 product.setAddTime(new Date());
    	 productService.insert(product);
    	 return "redirect:/product/findByObj.do";
	}
	
	
	/**
	 * 跳至修改页面
	 * @return
	 */
	@RequestMapping(value = "/update.do")
	public String update(Integer id,Model model) {
		//产品类型
		List<ProType> typeList = proTypeService.listAll();
		model.addAttribute("typeList", typeList);
		
		Product obj = productService.load(id);
		model.addAttribute("obj",obj);
		return "product/update";
	}
	
	/**
	 * 添加修改
	 * @return
	 */
	@RequestMapping(value = "/exUpdate.do")
	public String exUpdate(@RequestParam(value = "file", required = false) MultipartFile file,Product product,Integer type, Model model, HttpServletRequest request, HttpServletResponse response) {
		 if(!file.isEmpty()){
	    	 System.out.println("开始");  
	    	    // String path = request.getRealPath("/upload");
	    	     String path =  request.getSession().getServletContext().getRealPath("/")+"upload/";
		        //String path = request.getSession().getServletContext().getRealPath("/upload");  
		        String fileName = file.getOriginalFilename();  
		        System.out.println(path);  
		        File targetFile = new File(Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(0,Thread.currentThread().getContextClassLoader().getResource("").getPath().length()-16)+"/upload", fileName);  
		        if(!targetFile.exists()){  
		            targetFile.mkdirs();  
		        }  
		        product.setImage("/upload/" + fileName);
		        //保存  
		        try {  
		            file.transferTo(targetFile);  
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
	     }
		 product.setType(type);
		productService.update(product);
		return "redirect:/product/findByObj.do";
	}
	
	/**
	 * 删除通过主键
	 * @return
	 */
	@RequestMapping(value = "/delete.do")
	public String delete(Integer id, Model model, HttpServletRequest request, HttpServletResponse response) {
		//真正删除
		productService.deleteById(id);
		//通过参数删除
        //Map<String,Object> params = new HashMap<String,Object>();
		//params.put("id", id);
		//productService.deleteBySqId("deleteBySql", params);
		//状态删除
		//Product load = productService.load(id);
		//load.setIsDelete(1);
		//productService.update(load);
		return "redirect:/product/findByObj.do";
	}
	
	// --------------------------------------- 华丽分割线 ------------------------------
	
	/**
	 * 分页查询 返回list json(通过对象)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/findByObj.json", method = RequestMethod.GET)
	@ResponseBody
	public String findByObjByEntity(Product product, Model model, HttpServletRequest request, HttpServletResponse response) {
		//分页查询
		Pager<Product> pagers = productService.findByEntity(product);
		JSONObject jsonObject = JsonUtil2.getJsonObject();
		jsonObject.put("pagers", pagers);
		jsonObject.put("obj", product);
		return jsonObject.toString();
	}
	
	  
	/**
	 * 分页查询 返回list json(通过Map)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/findByMap.json", method = RequestMethod.GET)
	@ResponseBody
	public String findByMapMap(Product product, Model model, HttpServletRequest request, HttpServletResponse response) {
		//通过map查询
		Map<String,Object> params = new HashMap<String,Object>();
        if(!isEmpty(product.getContent())){
        	params.put("content", product.getContent());
		}
        if(!isEmpty(product.getAddTime())){
        	params.put("addTime", product.getAddTime());
		}
       /* if(!isEmpty(product.getAddUserId())){
        	params.put("addUserId", product.getAddUserId());
		}*/
		//分页查询
		Pager<Product> pagers = productService.findByMap(params);
		JSONObject jsonObject = JsonUtil2.getJsonObject();
		jsonObject.put("pagers", pagers);
		jsonObject.put("obj", product);
		return jsonObject.toString();
	}
	
	
	/**
	 * ajax 添加
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/exAdd.json", method = RequestMethod.POST)
	@ResponseBody
	public String exAddJson(Product product, Model model, HttpServletRequest request, HttpServletResponse response) {
		productService.insert(product);
		JSONObject jsonObject = JsonUtil2.getJsonObject();
		jsonObject.put("message", "添加成功");
		return jsonObject.toString();
	}
	

	/**
	 * ajax 修改
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/exUpdate.json",method = RequestMethod.POST)
	@ResponseBody
	public String exUpdateJson(Product product, Model model, HttpServletRequest request, HttpServletResponse response) {
		productService.update(product);
		JSONObject jsonObject = JsonUtil2.getJsonObject();
		jsonObject.put("message", "修改成功");
		return jsonObject.toString();
	}

	/**
	 * ajax 删除
	 * @return
	 */
	@RequestMapping(value = "/delete.json", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
	@ResponseBody
	public String exDeleteJson(Integer id, Model model, HttpServletRequest request, HttpServletResponse response) {
		//真正删除
		productService.deleteById(id);
		//通过参数删除
        //Map<String,Object> params = new HashMap<String,Object>();
		//params.put("id", id);
		//productService.deleteBySqId("deleteBySql", params);
		//状态删除
		//Product load = productService.load(id);
		//load.setIsDelete(1);
		//productService.update(load);
		JSONObject jsonObject = JsonUtil2.getJsonObject();
		jsonObject.put("message", "删除成功");
		return jsonObject.toString();
	}
	/**
	 * 单文件上传
	 * @param file
	 * @param request
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/saveFile")  
    public String saveFile(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, Model model) {  
  
        System.out.println("开始");  
        String path = request.getSession().getServletContext().getRealPath("/upload");  
        String fileName = file.getOriginalFilename();  
        System.out.println(path);  
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
        //保存  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return "";  
    }  
	
	
	/**
	 * springMvc多文件上传
	 * @param files
	 * @param id
	 * @return
	 */
    @RequestMapping(value = "/saveFiles")
    public String saveFiles(@RequestParam("file") CommonsMultipartFile[] files,Integer id,HttpServletRequest request){
		for(int i = 0;i<files.length;i++){
	      	System.out.println("fileName---------->" + files[i].getOriginalFilename());
		  if(!files[i].isEmpty()){
            int pre = (int) System.currentTimeMillis();
	     	try {
			//拿到输出流，同时重命名上传的文件
			 String filePath = request.getRealPath("/upload");
			 File f=new File(filePath);
			 if(!f.exists()){
				f.mkdirs();
			 }
		     String fileNmae=new Date().getTime() + files[i].getOriginalFilename();
		     File file=new File(filePath+"/"+pre + files[i].getOriginalFilename());
			  if(!file.exists()){
				  file.createNewFile();
			 }
			  files[i].transferTo(file);
		     } catch (Exception e) {
				e.printStackTrace();
				System.out.println("上传出错");
			 }
		  }
		}
	  return "";
	}
 // --------------------------------------- 华丽分割线 ------------------------------
	
	
}
