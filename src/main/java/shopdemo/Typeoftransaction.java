package shopdemo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typeoftransaction database table.
 * 
 */
@Entity
@NamedQuery(name="Typeoftransaction.findAll", query="SELECT t FROM Typeoftransaction t")
public class Typeoftransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idtypeOfTransaction;

	private String name;

	//bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy="typeoftransaction")
	private List<Transaction> transactions;

	public Typeoftransaction() {
	}

	public int getIdtypeOfTransaction() {
		return this.idtypeOfTransaction;
	}

	public void setIdtypeOfTransaction(int idtypeOfTransaction) {
		this.idtypeOfTransaction = idtypeOfTransaction;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Transaction> getTransactions() {
		return this.transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Transaction addTransaction(Transaction transaction) {
		getTransactions().add(transaction);
		transaction.setTypeoftransaction(this);

		return transaction;
	}

	public Transaction removeTransaction(Transaction transaction) {
		getTransactions().remove(transaction);
		transaction.setTypeoftransaction(null);

		return transaction;
	}

}