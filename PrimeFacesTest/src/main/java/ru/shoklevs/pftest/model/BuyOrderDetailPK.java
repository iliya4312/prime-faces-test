package ru.shoklevs.pftest.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the BUY_ORDER_DETAIL database table.
 * 
 */
@Embeddable
public class BuyOrderDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="\"POSITION\"", unique=true, nullable=false)
	private long position;

	@Column(name="FK_BUY_ORDER", insertable=false, updatable=false, unique=true, nullable=false)
	private long fkBuyOrder;

	public BuyOrderDetailPK() {
	}
	public long getPosition() {
		return this.position;
	}
	public void setPosition(long position) {
		this.position = position;
	}
	public long getFkBuyOrder() {
		return this.fkBuyOrder;
	}
	public void setFkBuyOrder(long fkBuyOrder) {
		this.fkBuyOrder = fkBuyOrder;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BuyOrderDetailPK)) {
			return false;
		}
		BuyOrderDetailPK castOther = (BuyOrderDetailPK)other;
		return 
			(this.position == castOther.position)
			&& (this.fkBuyOrder == castOther.fkBuyOrder);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.position ^ (this.position >>> 32)));
		hash = hash * prime + ((int) (this.fkBuyOrder ^ (this.fkBuyOrder >>> 32)));
		
		return hash;
	}
}