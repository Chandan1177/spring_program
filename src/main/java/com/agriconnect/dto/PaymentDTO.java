package com.agriconnect.dto;

public class PaymentDTO {
private int workId;
private String paymentStatus;
private float totalAmount;
private float receiveAmount;
private float discount;
private float dueAmount;

public int getWorkId() {
	return workId;
}
public void setWorkId(int workId) {
	this.workId = workId;
}
public String getPaymentStatus() {
	return paymentStatus;
}
public void setPaymentStatus(String paymentStatus) {
	this.paymentStatus = paymentStatus;
}
public float getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(float totalAmount) {
	this.totalAmount = totalAmount;
}
public float getReceiveAmount() {
	return receiveAmount;
}
public void setReceiveAmount(float receiveAmount) {
	this.receiveAmount = receiveAmount;
}
public float getDiscount() {
	return discount;
}
public void setDiscount(float discount) {
	this.discount = discount;
}
public float getDueAmount() {
	return dueAmount;
}
public void setDueAmount(float dueAmount) {
	this.dueAmount = dueAmount;
}
}
