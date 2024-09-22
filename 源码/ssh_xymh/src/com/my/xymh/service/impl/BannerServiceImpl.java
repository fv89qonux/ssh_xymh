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
import com.my.xymh.dao.BannerDao;
import com.my.xymh.entity.Banner;
import com.my.xymh.service.BannerService;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年02月18日 12时25分56秒
 */

@Service
public class BannerServiceImpl extends BaseServiceImpl<Banner> implements BannerService{
	 
	@Autowired
	private BannerDao bannerDao;

	@Override
	public BaseDao<Banner> getBaseDao()
	{
		return bannerDao;
	}
	


}
