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
import com.my.xymh.dao.ProductDao;
import com.my.xymh.entity.Product;
import com.my.xymh.service.ProductService;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2017年02月18日 12时25分56秒
 */

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService{
	 
	@Autowired
	private ProductDao productDao;

	@Override
	public BaseDao<Product> getBaseDao()
	{
		return productDao;
	}
	


}
