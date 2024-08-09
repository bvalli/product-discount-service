package com.productdiscount.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

/**
 * Product object which holds information of product's details like MRP, expiry date etc and
 * appropriate getters and setters of fields
 *
 */
public class Product {

	private double productMRP;
	private String productName;
	private LocalDate productEpiryDate;
	
	public double getProductMRP() {
		return productMRP;
	}
	public void setProductMRP(double productMRP) {
		this.productMRP = productMRP;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public LocalDate getProductEpiryDate() {
		return productEpiryDate;
	}
	public void setProductEpiryDate(LocalDate productEpiryDate) {
		this.productEpiryDate = productEpiryDate;
	}
	
	
	@Override
	public String toString() {
		return "Product [productMRP=" + productMRP + ", productName=" + productName + ", productEpiryDate="
				+ productEpiryDate + "]";
	}
	
	
}
