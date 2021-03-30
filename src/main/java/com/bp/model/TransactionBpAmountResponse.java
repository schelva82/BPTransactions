package com.bp.model;

public class TransactionBpAmountResponse {
	
	private String status;
	private String statusCode;
	private TransactionBpAmount amount;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public TransactionBpAmount getAmount() {
		return amount;
	}
	public void setAmount(TransactionBpAmount amount) {
		this.amount = amount;
	}
	

}
