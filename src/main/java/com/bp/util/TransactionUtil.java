package com.bp.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.bp.model.TransactionBp;

// TODO: Auto-generated Javadoc
/**
 * The Class TransactionUtil.
 */
public class TransactionUtil {

	/**
	 * Filter by type.
	 *
	 * @param type the type
	 * @param txns the txns
	 * @return the list
	 */
	public static List<TransactionBp> filterByType(String type, List<TransactionBp> txns) {
		List<TransactionBp> filtered = new ArrayList<TransactionBp>();
		if(!type.isEmpty()) {
			filtered = txns.stream().filter(txn -> type.equals(txn.getTransactionType())).collect(Collectors.toList());   
		}
		return filtered;
	}

	/**
	 * Gets the total amount by type.
	 *
	 * @param type the type
	 * @param txns the txns
	 * @return the total amount by type
	 */
	public static Double getTotalAmountByType(String type, List<TransactionBp> txns) {
		List<TransactionBp> filtered = new ArrayList<TransactionBp>();
		Double total = 0.0;
		if(!type.isEmpty()) {
			filtered = txns
					.stream()
					.filter(t -> type.equals(t.getTransactionType()))
					.collect(Collectors.toList());
			total = filtered.stream().mapToDouble(t -> t.getTransactionAmount()).sum();	
		}
		return total;
	}
}
