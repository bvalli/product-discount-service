package com.productdiscount.repo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.productdiscount.model.Product;


public class ProductDiscountRepository {

	
	/**
	 * static method to retrieve product details
	 */
	private static final Logger logger = LoggerFactory.getLogger(ProductDiscountRepository.class);
	public static List<Product> getProductList(){
		logger.info("getProductList method started {}");
		List<Product> productList;
		
		Product product1=new Product();
		product1.setProductName("Rice");
		product1.setProductMRP(500);
		product1.setProductEpiryDate( LocalDate.of(2024, 9, 18));
		
		Product product2=new Product();
		product2.setProductName("Milk");
		product2.setProductMRP(40);
		product2.setProductEpiryDate( LocalDate.of(2024, 8, 8));
		
		Product product3=new Product();
		product3.setProductName("Salt");
		product3.setProductMRP(80);
		product3.setProductEpiryDate( LocalDate.of(2024, 9, 30));
		
		Product product4=new Product();
		product4.setProductName("Pepper");
		product4.setProductMRP(150);
		product4.setProductEpiryDate( LocalDate.of(2024, 10, 18));
		
		Product product5=new Product();
		product5.setProductName("Paneer");
		product5.setProductMRP(200);
		product5.setProductEpiryDate( LocalDate.of(2024, 8, 9));
		
		Product product6=new Product();
		product6.setProductName("Thumsup");
		product6.setProductMRP(30);
		product6.setProductEpiryDate( LocalDate.of(2024, 8, 7));
		
		Product product7=new Product();
		product7.setProductName("Dairy Milk");
		product7.setProductMRP(50);
		product7.setProductEpiryDate( LocalDate.of(2024, 8, 7));
		
		Product product8=new Product();
		product8.setProductName("Curd");
		product8.setProductMRP(48);
		product8.setProductEpiryDate( LocalDate.of(2024, 8, 9));
		
		productList=Arrays.asList(product1,product2,product3,product4,product5,product6,product7,product8);
		logger.info("Product_Info={}",productList);
		return productList;
	}
	
	/**
	 * Here defined few items as non perished product category and few other items into
	 * non perished product category so based on that category discount will be applied.
	 */
	
	/**
	 * static method to retrieve perished products
	 */
	
	public static List<String> getPerishedGoods(){
		return Arrays.asList("Milk","Vegetables","Paneer","Curd");
	}
	
	/**
	 * static method to retrieve non perished products. 
	 * 
	 */
	
	public static List<String> getNonPerishedGoods(){
		return Arrays.asList("Rice","Salt","Pepper");
	}
	
	/**
	 * static method to fetch discount to apply particular product. 
	 * 
	 */
	public static double getDiscountToApply(String productName, LocalDate ExpiryDate) {
		
		double discountToApply = 0;
		long daysToExpiry = ChronoUnit.DAYS.between(LocalDate.now(), ExpiryDate);

		if (getPerishedGoods().contains(productName)) {
			if (daysToExpiry <= 1) {
				discountToApply = 35;
			} else if (daysToExpiry == 2) {
				discountToApply = 25;
			} else if (daysToExpiry == 3) {
				discountToApply = 15;
			}
		} else if (getNonPerishedGoods().contains(productName)) {
			if (daysToExpiry <= 15) {
				discountToApply = 50;
			} else if (daysToExpiry <= 30) {
				discountToApply = 30;
			} else if (daysToExpiry <= 60) {
				discountToApply = 20;
			} else if (daysToExpiry <= 90) {
				discountToApply = 10;
			}
		}

		return discountToApply;
	}
}
