package com.bp.model;

import java.util.List;

public class TransactionBpResponse {
	
	private String status;
	private String statusCode;
	private List<TransactionBp> transactions;
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
	public List<TransactionBp> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<TransactionBp> transactions) {
		this.transactions = transactions;
	}

}
