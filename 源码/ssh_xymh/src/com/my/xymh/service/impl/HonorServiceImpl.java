/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年02月18日 12时25分56秒
 */
package com.my.xymh.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.xymh.base.BaseDao;
import com.my.xymh.base.BaseServiceImpl;
import com.my.xymh.dao.HonorDao;
import com.my.xymh.entity.Honor;
import com.my.xymh.service.HonorService;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年02月18日 12时25分56秒
 */

@Service
public class HonorServiceImpl extends BaseServiceImpl<Honor> implements HonorService{
	 
	@Autowired
	private HonorDao honorDao;

	@Override
	public BaseDao<Honor> getBaseDao()
	{
		return honorDao;
	}
	


}
