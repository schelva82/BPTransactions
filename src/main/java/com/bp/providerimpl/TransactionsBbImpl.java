package com.bp.providerimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.bp.model.TransactionBp;
import com.bp.provider.TransactionsBb;
import com.openbank.model.Transaction;
import com.openbank.model.Transactions;

// TODO: Auto-generated Javadoc
/**
 * The Class TransactionsBbImpl.
 */
@Component
public class TransactionsBbImpl implements TransactionsBb {
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger("TransactionsBbImpl");

	/**
	 * Gets the transaction.
	 *
	 * @param sandBoxUrl the sand box url
	 * @return the transaction
	 * @throws Exception the exception
	 */
	@Override
	public List<TransactionBp> getTransaction(String sandBoxUrl) throws Exception {
		List<TransactionBp> bpTxnList = new ArrayList<TransactionBp>();
		try {
			if(sandBoxUrl != null) {
				RestTemplate restTemplate = new RestTemplate();
				Transactions tx = restTemplate.getForObject(sandBoxUrl, Transactions.class);
				transform(tx, bpTxnList);
			}
		}catch(Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw e;
		}
		return bpTxnList;
	}

	/**
	 * Transform.
	 *
	 * @param txns the txns
	 * @param bpTxnList the bp txn list
	 * @throws Exception the exception
	 */
	private void transform(Transactions txns, List<TransactionBp> bpTxnList) throws Exception{
		logger.info("getTransactions:"+txns.getTransactions());
		try {
			for (Transaction txn: txns.getTransactions()) {
				TransactionBp txnBp = new TransactionBp();
				txnBp.setId(txn.getId());
				if(txn.getThisAccount() != null) {
					txnBp.setAccountId(txn.getThisAccount().getId());
				}
				if(txn.getOtherAccount() != null) {
					txnBp.setCounterpartyAccount(txn.getOtherAccount().getNumber());
					if(txn.getOtherAccount().getHolder() != null) {
						txnBp.setCounterpartyName(txn.getOtherAccount().getHolder().getName());
					}
					if(txn.getOtherAccount().getMetadata()!= null && txn.getOtherAccount().getMetadata().getImageURL() != null) {
						txnBp.setCounterpartyLogoPath(txn.getOtherAccount().getMetadata().getImageURL().toString());
					}
					if(txn.getDetails() != null && txn.getDetails().getValue() != null) {
						if(txn.getDetails().getValue().getAmount() != null) {
							Double amt = Double.valueOf(txn.getDetails().getValue().getAmount());
							txnBp.setInstructedAmount(amt);
							txnBp.setTransactionAmount(amt);
						}

						txnBp.setInstructedCurrency(txn.getDetails().getValue().getCurrency());

						txnBp.setTransactionCurrency(txn.getDetails().getValue().getCurrency());
						txnBp.setTransactionType(txn.getDetails().getType());
						txnBp.setDescription(txn.getDetails().getDescription());
					}

					bpTxnList.add(txnBp);
					logger.info("getTransactions getId:"+txn.getId());
				}

			}
		}
		catch(Exception e) {
			e.printStackTrace();
			logger.error(e);
			throw e;
		}
	}
}
