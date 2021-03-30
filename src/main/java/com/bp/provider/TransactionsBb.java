package com.bp.provider;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bp.model.TransactionBp;

@Component
public interface TransactionsBb {
	
	public List<TransactionBp> getTransaction(String sandBoxUrl) throws Exception;

}
