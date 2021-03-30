package com.bp.model;

public class TransactionBpAmount {

	
	private String transactionType;
	private Double totalAmount;
	
	public TransactionBpAmount(String transactionType, Double totalAmount) {
		super();
		this.transactionType = transactionType;
		this.totalAmount = totalAmount;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
}
