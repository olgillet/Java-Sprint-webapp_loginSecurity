package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Product> getAllProductByPriceRange(int price1, int price2) {
		return em.createQuery("from Product p where p.unitPrice >= " + price1 + " and p.unitPrice<= " + price2).getResultList();
	}

	@Override
	public List<Product> findAll() {
		return em.createQuery("from Product").getResultList();
	}

	@Override
	public Product findOne(Long id) {
		return em.find(Product.class, id);
	}

	@Override
	public Product create(Product entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public Product update(Product entity) {
		return em.merge(em.find(Product.class, entity.getId()));
	}

	@Override
	public void deleteById(Long id) {
		em.remove(em.find(Product.class, id));
	}

	@Override
	public void delete(Product entity) {
		// TODO Auto-generated method stub
		em.remove(entity);
	}
}
