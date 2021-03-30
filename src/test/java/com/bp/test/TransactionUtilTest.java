package com.bp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bp.model.TransactionBp;
import com.bp.provider.TransactionsBb;
import com.bp.providerimpl.TransactionsBbImpl;
import com.bp.util.TransactionUtil;

public class TransactionUtilTest {

	private static final String sandboxUrl = "https://apisandbox.openbankproject.com/obp/v1.2.1/banks/rbs/accounts/savings-kids-john/public/transactions";

	TransactionsBb transactions = new TransactionsBbImpl();

	@Before
	public void setup() {

	}

	@Test
	public void getTransactionUtilTest1() throws Exception {
		List<TransactionBp> response = transactions.getTransaction(sandboxUrl);
		response = TransactionUtil.filterByType("SEPA", response);
		Assert.assertNotNull(response);
		for (TransactionBp transactionBp : response) {
			Assert.assertNotNull(transactionBp.getAccountId());
		}
	}

	@Test
	public void getTransactionUtilTest2() throws Exception {
		List<TransactionBp> response = transactions.getTransaction(null);
		Double total = TransactionUtil.getTotalAmountByType("SEPA", response);
		Assert.assertNotNull(total);
		Double zero = 0.0;
		assertNotSame(zero, total);
	}

	@Test
	public void getTransactionUtilTest3() throws Exception {
		List<TransactionBp> response = transactions.getTransaction(null);
		Double total = TransactionUtil.getTotalAmountByType("", response);
		Assert.assertNotNull(total);
		Double zero = 0.0;
		assertEquals(zero, total);
	}

	@Test
	public void getTransactionUtilTest4() throws Exception {
		Double total = TransactionUtil.getTotalAmountByType("", null);
		Assert.assertNotNull(total);
		Double zero = 0.0;
		assertEquals(zero, total);
	}
}
