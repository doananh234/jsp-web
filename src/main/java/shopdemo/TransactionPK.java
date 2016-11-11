package shopdemo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the transaction database table.
 * 
 */
@Embeddable
public class TransactionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idtransaction;

	private int typeoftransaction_idtypeOfTransaction;

	@Column(name="user_id")
	private int userId;

	@Column(name="product_idproduct")
	private int productIdproduct;

	public TransactionPK() {
	}
	public int getIdtransaction() {
		return this.idtransaction;
	}
	public void setIdtransaction(int idtransaction) {
		this.idtransaction = idtransaction;
	}
	public int getTypeoftransaction_idtypeOfTransaction() {
		return this.typeoftransaction_idtypeOfTransaction;
	}
	public void setTypeoftransaction_idtypeOfTransaction(int typeoftransaction_idtypeOfTransaction) {
		this.typeoftransaction_idtypeOfTransaction = typeoftransaction_idtypeOfTransaction;
	}
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductIdproduct() {
		return this.productIdproduct;
	}
	public void setProductIdproduct(int productIdproduct) {
		this.productIdproduct = productIdproduct;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TransactionPK)) {
			return false;
		}
		TransactionPK castOther = (TransactionPK)other;
		return 
			(this.idtransaction == castOther.idtransaction)
			&& (this.typeoftransaction_idtypeOfTransaction == castOther.typeoftransaction_idtypeOfTransaction)
			&& (this.userId == castOther.userId)
			&& (this.productIdproduct == castOther.productIdproduct);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idtransaction;
		hash = hash * prime + this.typeoftransaction_idtypeOfTransaction;
		hash = hash * prime + this.userId;
		hash = hash * prime + this.productIdproduct;
		
		return hash;
	}
}