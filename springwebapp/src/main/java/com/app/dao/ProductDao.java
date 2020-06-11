package com.app.dao;

import java.util.List;
import com.app.model.Product;

public interface ProductDao extends GenericDao<Long, Product> {
	public List<Product> getAllProductByPriceRange(int price1, int price2);
	
	
}
