package com.my.xymh.controller.manage;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
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
import com.my.xymh.entity.Banner;
import com.my.xymh.service.BannerService;
import com.my.xymh.utils.JsonUtil2;
import com.my.xymh.utils.Pager;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年02月18日 12时25分56秒
 */


@Controller
@RequestMapping("/banner")
public class BannerController extends BaseController {
	
	/**
	 * 依赖注入 start dao/service/===
	 */
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
	public String findByObj(Banner banner, Model model, HttpServletRequest request, HttpServletResponse response) {
		/* Object attribute = request.getSession().getAttribute("isManage");
	 		if(isEmpty(attribute)){
	 			Integer id2 = Integer.valueOf(request.getSession().getAttribute("userId").toString());
	 			banner.setAddUserId(id2);
	 		}*/
		//分页查询
		Pager<Banner> pagers = bannerService.findByEntity(banner);
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", banner);
		return "banner/banner";
	}
	
	
	/**
	 * 分页查询 返回list对象(通过Map)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/findByMap.do")
	public String findByMap(Banner banner, Model model, HttpServletRequest request, HttpServletResponse response) {
		//通过map查询
		Map<String,Object> params = new HashMap<String,Object>();
        if(!isEmpty(banner.getContent())){
        	params.put("content", banner.getContent());
		}
        if(!isEmpty(banner.getAddTime())){
        	params.put("addTime", banner.getAddTime());
		}
        /*if(!isEmpty(banner.getAddUserId())){
        	params.put("addUserId", banner.getAddUserId());
		}*/
		//分页查询
		Pager<Banner> pagers = bannerService.findByMap(params);
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", banner);
		return "banner/banner";
	}
	
	
	/**
	 * 跳至添加页面
	 * @return
	 */
	@RequestMapping(value = "/add.do")
	public String add() {
		return "banner/add";
	}

	
	/**
	 * 添加执行
	 * @return
	 */
    @RequestMapping(value = "/exAdd.do")
    public String manageMain(@RequestParam(value = "file", required = false) MultipartFile file,Banner banner,Integer id,HttpServletRequest request){
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
		        banner.setContent("/upload/" + fileName);
		        //保存  
		        try {  
		            file.transferTo(targetFile);  
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
	     }
    	 //Object attribute = request.getSession().getAttribute("isManage");
 		/*if(isEmpty(attribute)){
 			Integer id2 = Integer.valueOf(request.getSession().getAttribute("userId").toString());
 			banner.setAddUserId(id2);
 		}*/
    	 banner.setAddTime(new Date());
    	 bannerService.insert(banner);
    	 /**
 		 * 下面执行短信推送
 		 * 	d1.setNum(1);
 		d1.setName("新闻快讯");
 		dtos.add(d1);
 		GzDto d2 = new GzDto();
 		d2.setNum(2);
 		d2.setName("通知公告");
 		dtos.add(d2);
 		GzDto d3 = new GzDto();
 		d3.setNum(3);
 		d3.setName("求职招聘");
 		dtos.add(d3);
 		GzDto d4 = new GzDto();
 		d4.setNum(4);
 		d4.setName("校园风采");
 		dtos.add(d4);
 		 */
 		//gzService.send(4,banner.getTitle());
    	 return "redirect:/banner/findByObj.do";
	}
	
	
	/**
	 * 跳至修改页面
	 * @return
	 */
	@RequestMapping(value = "/update.do")
	public String update(Integer id,Model model) {
		Banner obj = bannerService.load(id);
		model.addAttribute("obj",obj);
		return "banner/update";
	}
	
	/**
	 * 添加修改
	 * @return
	 */
	@RequestMapping(value = "/exUpdate.do")
	public String exUpdate(@RequestParam(value = "file", required = false) MultipartFile file,Banner banner, Model model, HttpServletRequest request, HttpServletResponse response) {
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
		        banner.setContent("/upload/" + fileName);
		        //保存  
		        try {  
		            file.transferTo(targetFile);  
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }  
	     }
		bannerService.update(banner);
		return "redirect:/banner/findByObj.do";
	}
	
	/**
	 * 删除通过主键
	 * @return
	 */
	@RequestMapping(value = "/delete.do")
	public String delete(Integer id, Model model, HttpServletRequest request, HttpServletResponse response) {
		//真正删除
		bannerService.deleteById(id);
		//通过参数删除
        //Map<String,Object> params = new HashMap<String,Object>();
		//params.put("id", id);
		//bannerService.deleteBySqId("deleteBySql", params);
		//状态删除
		//Banner load = bannerService.load(id);
		//load.setIsDelete(1);
		//bannerService.update(load);
		return "redirect:/banner/findByObj.do";
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
	public String findByObjByEntity(Banner banner, Model model, HttpServletRequest request, HttpServletResponse response) {
		//分页查询
		Pager<Banner> pagers = bannerService.findByEntity(banner);
		JSONObject jsonObject = JsonUtil2.getJsonObject();
		jsonObject.put("pagers", pagers);
		jsonObject.put("obj", banner);
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
	public String findByMapMap(Banner banner, Model model, HttpServletRequest request, HttpServletResponse response) {
		//通过map查询
		Map<String,Object> params = new HashMap<String,Object>();
        if(!isEmpty(banner.getContent())){
        	params.put("content", banner.getContent());
		}
        if(!isEmpty(banner.getAddTime())){
        	params.put("addTime", banner.getAddTime());
		}
       /* if(!isEmpty(banner.getAddUserId())){
        	params.put("addUserId", banner.getAddUserId());
		}*/
		//分页查询
		Pager<Banner> pagers = bannerService.findByMap(params);
		JSONObject jsonObject = JsonUtil2.getJsonObject();
		jsonObject.put("pagers", pagers);
		jsonObject.put("obj", banner);
		return jsonObject.toString();
	}
	
	
	/**
	 * ajax 添加
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/exAdd.json", method = RequestMethod.POST)
	@ResponseBody
	public String exAddJson(Banner banner, Model model, HttpServletRequest request, HttpServletResponse response) {
		bannerService.insert(banner);
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
	public String exUpdateJson(Banner banner, Model model, HttpServletRequest request, HttpServletResponse response) {
		bannerService.update(banner);
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
		bannerService.deleteById(id);
		//通过参数删除
        //Map<String,Object> params = new HashMap<String,Object>();
		//params.put("id", id);
		//bannerService.deleteBySqId("deleteBySql", params);
		//状态删除
		//Banner load = bannerService.load(id);
		//load.setIsDelete(1);
		//bannerService.update(load);
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
