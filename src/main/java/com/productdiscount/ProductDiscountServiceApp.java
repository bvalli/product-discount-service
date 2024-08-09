package com.productdiscount;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.productdiscount.model.Product;
import com.productdiscount.service.ProductDiscountService;

/**
 * This is the main method where we are calling the method in ProductService in order to 
 * initiate method call to update price details of all the products after applying discount
 *
 */

public class ProductDiscountServiceApp 
{
	private static final Logger logger = LoggerFactory.getLogger(ProductDiscountServiceApp.class);
    public static void main( String[] args )
    {
        ProductDiscountService productService=new ProductDiscountService();
        Optional<List<Product>> productDiscountDetails = productService.getUpdatedProductDetails();
        logger.info("Updated Product Prices After Discount");
        logger.info("=====================================");
        logger.info(productDiscountDetails.toString());
    }
}
