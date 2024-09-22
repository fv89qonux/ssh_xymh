/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年02月19日 21时18分33秒
 */
package com.my.xymh.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.xymh.base.BaseDao;
import com.my.xymh.base.BaseServiceImpl;
import com.my.xymh.dao.ProTypeDao;
import com.my.xymh.entity.ProType;
import com.my.xymh.service.ProTypeService;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年02月19日 21时18分33秒
 */

@Service
public class ProTypeServiceImpl extends BaseServiceImpl<ProType> implements ProTypeService{
	 
	@Autowired
	private ProTypeDao proTypeDao;
	@Override
	public BaseDao<ProType> getBaseDao() {
		return proTypeDao;
	}

}
