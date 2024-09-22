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
import com.my.xymh.dao.ConfigDao;
import com.my.xymh.entity.Config;
import com.my.xymh.service.ConfigService;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年02月18日 12时25分55秒
 */

@Service
public class ConfigServiceImpl extends BaseServiceImpl<Config> implements ConfigService{
	 
	@Autowired
	private ConfigDao configDao;
	@Override
	public BaseDao<Config> getBaseDao() {
		return configDao;
	}

}
