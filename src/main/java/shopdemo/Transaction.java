package shopdemo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the transaction database table.
 * 
 */
@Entity
@NamedQuery(name="Transaction.findAll", query="SELECT t FROM Transaction t")
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TransactionPK id;

	private String payment;

	private int quality;

	@Temporal(TemporalType.DATE)
	private Date transactionTime;

	//bi-directional many-to-one association to Typeoftransaction
	@ManyToOne
	@JoinColumn(name="typeoftransaction_idtypeOfTransaction")
	private Typeoftransaction typeoftransaction;

	public Transaction() {
	}

	public TransactionPK getId() {
		return this.id;
	}

	public void setId(TransactionPK id) {
		this.id = id;
	}

	public String getPayment() {
		return this.payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public int getQuality() {
		return this.quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public Date getTransactionTime() {
		return this.transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}

	public Typeoftransaction getTypeoftransaction() {
		return this.typeoftransaction;
	}

	public void setTypeoftransaction(Typeoftransaction typeoftransaction) {
		this.typeoftransaction = typeoftransaction;
	}

}