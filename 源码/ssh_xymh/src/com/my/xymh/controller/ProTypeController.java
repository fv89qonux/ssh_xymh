package com.my.xymh.controller;
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
import com.my.xymh.entity.ProType;
import com.my.xymh.service.ProTypeService;
import com.my.xymh.utils.JsonUtil2;
import com.my.xymh.utils.Pager;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年02月19日 21时18分33秒
 */


@Controller
@RequestMapping("/proType")
public class ProTypeController extends BaseController {
	
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private ProTypeService proTypeService;
	
	// --------------------------------------- 华丽分割线 ------------------------------
	
	/**
	 * 分页查询 返回list对象(通过对象)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/findByObj.do")
	public String findByObj(ProType proType, Model model, HttpServletRequest request, HttpServletResponse response) {
		//分页查询
		Pager<ProType> pagers = proTypeService.findByEntity(proType);
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", proType);
		return "proType/proType";
	}
	
	@RequestMapping(value = "/findByObj2.do")
	public String findByObj2(ProType proType, Model model, HttpServletRequest request, HttpServletResponse response) {
		//分页查询
		Pager<ProType> pagers = proTypeService.findByEntity(proType);
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", proType);
		return "proType/proType2";
	}
	
	@RequestMapping(value = "/detail.do")
	public String detail(Integer id,Model model) {
		ProType obj = proTypeService.load(id);
		model.addAttribute("obj",obj);
		return "proType/detail";
	}
	/**
	 * 分页查询 返回list对象(通过Map)
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/findByMap.do")
	public String findByMap(ProType proType, Model model, HttpServletRequest request, HttpServletResponse response) {
		//通过map查询
		Map<String,Object> params = new HashMap<String,Object>();
        if(!isEmpty(proType.getTitle())){
        	params.put("title", proType.getTitle());
		}
		//分页查询
		Pager<ProType> pagers = proTypeService.findByMap(params);
		model.addAttribute("pagers", pagers);
		//存储查询条件
		model.addAttribute("obj", proType);
		return "proType/proType";
	}
	
	
	/**
	 * 跳至添加页面
	 * @return
	 */
	@RequestMapping(value = "/add.do")
	public String add() {
		return "proType/add";
	}

	
	/**
	 * 添加执行
	 * @return
	 */
	@RequestMapping(value = "/exAdd.do")
	public String exAdd(ProType proType, Model model, HttpServletRequest request, HttpServletResponse response) {
		proTypeService.insert(proType);
		return "redirect:/proType/findByObj.do";
	}
	
	
	/**
	 * 跳至修改页面
	 * @return
	 */
	@RequestMapping(value = "/update.do")
	public String update(Integer id,Model model) {
		ProType obj = proTypeService.load(id);
		model.addAttribute("obj",obj);
		return "proType/update";
	}
	
	/**
	 * 添加修改
	 * @return
	 */
	@RequestMapping(value = "/exUpdate.do")
	public String exUpdate(ProType proType, Model model, HttpServletRequest request, HttpServletResponse response) {
		proTypeService.update(proType);
		return "redirect:/proType/findByObj.do";
	}
	
	/**
	 * 删除通过主键
	 * @return
	 */
	@RequestMapping(value = "/delete.do")
	public String delete(Integer id, Model model, HttpServletRequest request, HttpServletResponse response) {
		//真正删除
		proTypeService.deleteById(id);
		//通过参数删除
        //Map<String,Object> params = new HashMap<String,Object>();
		//params.put("id", id);
		//proTypeService.deleteBySqId("deleteBySql", params);
		//状态删除
		//ProType load = proTypeService.load(id);
		//load.setIsDelete(1);
		//proTypeService.update(load);
		return "redirect:/proType/findByObj.do";
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
	public String findByObjByEntity(ProType proType, Model model, HttpServletRequest request, HttpServletResponse response) {
		//分页查询
		Pager<ProType> pagers = proTypeService.findByEntity(proType);
		JSONObject jsonObject = JsonUtil2.getJsonObject();
		jsonObject.put("pagers", pagers);
		jsonObject.put("obj", proType);
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
	public String findByMapMap(ProType proType, Model model, HttpServletRequest request, HttpServletResponse response) {
		//通过map查询
		Map<String,Object> params = new HashMap<String,Object>();
        if(!isEmpty(proType.getTitle())){
        	params.put("title", proType.getTitle());
		}
		//分页查询
		Pager<ProType> pagers = proTypeService.findByMap(params);
		JSONObject jsonObject = JsonUtil2.getJsonObject();
		jsonObject.put("pagers", pagers);
		jsonObject.put("obj", proType);
		return jsonObject.toString();
	}
	
	
	/**
	 * ajax 添加
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/exAdd.json", method = RequestMethod.POST)
	@ResponseBody
	public String exAddJson(ProType proType, Model model, HttpServletRequest request, HttpServletResponse response) {
		proTypeService.insert(proType);
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
	public String exUpdateJson(ProType proType, Model model, HttpServletRequest request, HttpServletResponse response) {
		proTypeService.update(proType);
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
		proTypeService.deleteById(id);
		//通过参数删除
        //Map<String,Object> params = new HashMap<String,Object>();
		//params.put("id", id);
		//proTypeService.deleteBySqId("deleteBySql", params);
		//状态删除
		//ProType load = proTypeService.load(id);
		//load.setIsDelete(1);
		//proTypeService.update(load);
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
