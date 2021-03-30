package com.bp.controller;

import java.util.List;

import static com.bp.util.TransactionConstants.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bp.model.TransactionBp;
import com.bp.model.TransactionBpAmount;
import com.bp.model.TransactionBpAmountResponse;
import com.bp.model.TransactionBpResponse;
import com.bp.providerimpl.TransactionsBbImpl;
import com.bp.util.TransactionUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class TransactionBbController.
 */
@Controller
@RequestMapping(value = "/transactions")
public class TransactionBbController {
	
	/** The Constant log. */
	private static final Logger log = Logger.getLogger(TransactionBbController.class.getName());
	
	/** The transactions. */
	@Autowired
	TransactionsBbImpl transactions;

	/**
	 * Say hello.
	 *
	 * @return the response entity
	 */
	@RequestMapping(value = "/health", method = RequestMethod.GET)
	public ResponseEntity<String> sayHello() {
		return new ResponseEntity<String>("UP!!!", HttpStatus.OK);
	}

	/**
	 * Gets the transactions.
	 *
	 * @return the transactions
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<TransactionBpResponse> getTransactions() {
		TransactionBpResponse response = new TransactionBpResponse();
		try {
			log.info("List Transactions");
			
			List<TransactionBp> txns = transactions.getTransaction(SANDBOX_URL);
			log.info("txns list:"+txns);
			response.setTransactions(txns);
			response.setStatus(SUCCESS);
			response.setStatusCode(SUCCESS_CODE);
			return new ResponseEntity<TransactionBpResponse>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			log.error(e);
			response.setStatus(FAILED);
			response.setStatusCode(FAILED_CODE);
			return new ResponseEntity<TransactionBpResponse>(response, HttpStatus.OK);
		}
	}
	
	/**
	 * Filter transactions.
	 *
	 * @param type the type
	 * @return the response entity
	 */
	@RequestMapping(value = "/list/{type}", method = RequestMethod.GET)
	public ResponseEntity<TransactionBpResponse> filterTransactions(@PathVariable("type") String type) {
		TransactionBpResponse response = new TransactionBpResponse();
		try {
			log.info("get Transactions for "+type);
			List<TransactionBp> txns = transactions.getTransaction(SANDBOX_URL);
			log.info("txns list:"+txns);
			//
			List<TransactionBp> filtered = TransactionUtil.filterByType(type, txns);
			//
			response.setTransactions(filtered);
			response.setStatus(SUCCESS);
			response.setStatusCode(SUCCESS_CODE);
			log.info("response:"+response);
			return new ResponseEntity<TransactionBpResponse>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			log.error(e);
			response.setStatus(FAILED);
			response.setStatusCode(FAILED_CODE);
			return new ResponseEntity<TransactionBpResponse>(response, HttpStatus.OK);
		}

	}
	
	/**
	 * Gets the total amount.
	 *
	 * @param type the type
	 * @return the total amount
	 */
	@RequestMapping(value = "/totalAmount/{type}", method = RequestMethod.GET)
	public ResponseEntity<TransactionBpAmountResponse> getTotalAmount(@PathVariable("type") String type) {
		TransactionBpAmountResponse response = new TransactionBpAmountResponse();
		try {
			log.info("get Transactions total amount for type "+type);
			List<TransactionBp> txns = transactions.getTransaction(SANDBOX_URL);
			log.info("txns list:"+txns);
			//
			Double total = TransactionUtil.getTotalAmountByType(type, txns);
			//
			response.setAmount(new TransactionBpAmount(type,total));
			response.setStatus(SUCCESS);
			response.setStatusCode(SUCCESS_CODE);
			log.info("response:"+response);
			return new ResponseEntity<TransactionBpAmountResponse>(response, HttpStatus.OK);
		}
		catch(Exception e) {
			log.error(e);
			response.setStatus(FAILED);
			response.setStatusCode(FAILED_CODE);
			return new ResponseEntity<TransactionBpAmountResponse>(response, HttpStatus.OK);
		}

	}

}
