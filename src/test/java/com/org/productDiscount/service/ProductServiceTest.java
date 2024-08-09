package com.org.productDiscount.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.productdiscount.model.Product;
import com.productdiscount.repo.ProductDiscountRepository;

class ProductServiceTest {

	List<Product> productList = ProductDiscountRepository.getProductList().stream().peek(product -> {
		double discountToApply= ProductDiscountRepository.getDiscountToApply(product.getProductName(), product.getProductEpiryDate());
		double discountedPrice = product.getProductMRP() - (product.getProductMRP() * discountToApply);
		product.setProductMRP(discountedPrice);

	}).collect(Collectors.toList());
	
	@Test
	void testUpdatedMRPofValidProductMilk() {
		
		double finalProductMRP=productList.get(1).getProductMRP();
		
		Assertions.assertEquals(finalProductMRP, 26.0);
		
	}
	
	/**
	 * In the below testcase, i have considered get(6) as product DairyMilk. 
	 * As it not listed in perished or non perished goods, its MRP should not apply discount
	 */
	@Test
	void testUpdatedMRPofInvalidProduct() {
		
		double finalProductMRP=productList.get(6).getProductMRP();
		
		Assertions.assertEquals(finalProductMRP, 50);
		
	}

}
