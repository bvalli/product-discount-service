package com.productdiscount.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.productdiscount.model.Product;
import com.productdiscount.repo.ProductDiscountRepository;

/**
 *  * getUpdatedProductDetails() method for calculating final price of product 
 * after applying discount. Here discount percentage varies from perished goods 
 * to non perished goods
 * 	 * 
 *  If any product which is not present in perished or non perished goods list
 *  then no discount will be applied on product. 
 *  The final price will be the actual price
 */

public class ProductDiscountService {

	private static final Logger logger = LoggerFactory.getLogger(ProductDiscountService.class);
	public Optional<List<Product>> getUpdatedProductDetails() {
		logger.info("getUpdatedProductDetails method started {}");
		List<Product> productList = ProductDiscountRepository.getProductList().stream().peek(product -> {
			double discountToApply= ProductDiscountRepository.getDiscountToApply(product.getProductName(), product.getProductEpiryDate());
			double discountedPrice = product.getProductMRP() - (product.getProductMRP() * (discountToApply/100));
			product.setProductMRP(discountedPrice);

		}).collect(Collectors.toList());
		logger.info("Product_list_after_applying_discount_on_products {}"+productList);
		return Optional.of(productList);
	}
}
