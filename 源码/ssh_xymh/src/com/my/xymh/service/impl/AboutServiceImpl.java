/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年02月18日 12时25分55秒
 */
package com.my.xymh.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.xymh.base.BaseDao;
import com.my.xymh.base.BaseServiceImpl;
import com.my.xymh.dao.AboutDao;
import com.my.xymh.entity.About;
import com.my.xymh.service.AboutService;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年02月18日 12时25分55秒
 */

@Service
public class AboutServiceImpl extends BaseServiceImpl<About> implements AboutService{
	 
	@Autowired
	private AboutDao aboutDao;
	@Override
	public BaseDao<About> getBaseDao() {
		return aboutDao;
	}

}
