package com.agriconnect.dto;

public class ProductDTO {
private String productName;
private String productDescreption;
private String productImg;
private String categoryID;
private float productPrice;
private String unit;
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getProductDescreption() {
	return productDescreption;
}
public void setProductDescreption(String productDescreption) {
	this.productDescreption = productDescreption;
}
public String getProductImg() {
	return productImg;
}
public void setProductImg(String productImg) {
	this.productImg = productImg;
}
public String getCategoryID() {
	return categoryID;
}
public void setCategoryID(String categoryID) {
	this.categoryID = categoryID;
}
public float getProductPrice() {
	return productPrice;
}
public void setProductPrice(float productPrice) {
	this.productPrice = productPrice;
}
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}
}
