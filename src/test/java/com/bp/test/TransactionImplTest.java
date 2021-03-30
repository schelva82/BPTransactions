package com.bp.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bp.model.TransactionBp;
import com.bp.provider.TransactionsBb;
import com.bp.providerimpl.TransactionsBbImpl;

public class TransactionImplTest {

	private static final String sandboxUrl = "https://apisandbox.openbankproject.com/obp/v1.2.1/banks/rbs/accounts/savings-kids-john/public/transactions";

	TransactionsBb transactions = new TransactionsBbImpl();

	@Before
	public void setup() {

	}

	@Test
	public void getTransactionTes1t() throws Exception {
		List<TransactionBp> response = transactions.getTransaction(sandboxUrl);
		Assert.assertNotNull(response);
		for (TransactionBp transactionBp : response) {
			Assert.assertNotNull(transactionBp.getAccountId());
		}
	}

	@Test
	public void getTransactionTest2() throws Exception {
		List<TransactionBp> response = transactions.getTransaction(null);
		Assert.assertNotNull(response);
		for (TransactionBp transactionBp : response) {
			Assert.assertNull(transactionBp.getAccountId());
		}
	}
}
