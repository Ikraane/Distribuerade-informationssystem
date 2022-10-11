package com.test.beans;

import com.test.dao.ProductDB;

import java.util.Collection;

public class Product {

	private int productId;
	private String productName;
	private String productImgPath;

	static public Collection searchProduct(String group) {return ProductDB.searchProduct(group);}
	protected Product(int productId, String productName, String productImgPath) {
		this.productId = productId;
		this.productName = productName;
		this.productImgPath = productImgPath;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImgPath() {
		return productImgPath;
	}

	public void setProductImgPath(String productImgPath) {
		this.productImgPath = productImgPath;
	}

}
