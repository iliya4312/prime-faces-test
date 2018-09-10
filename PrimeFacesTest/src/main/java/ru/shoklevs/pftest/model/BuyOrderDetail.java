package ru.shoklevs.pftest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the BUY_ORDER_DETAIL database table.
 * 
 */
@Entity
@Table(name="BUY_ORDER_DETAIL")
@NamedQuery(name="BuyOrderDetail.findAll", query="SELECT b FROM BuyOrderDetail b")
public class BuyOrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BuyOrderDetailPK id;

	private BigDecimal quantity;

	//bi-directional many-to-one association to BuyOrder
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FK_BUY_ORDER", nullable=false, insertable=false, updatable=false)
	private BuyOrder buyOrder;

	//bi-directional many-to-one association to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FK_PRODUCT")
	private Product product;

	public BuyOrderDetail() {
	}

	public BuyOrderDetailPK getId() {
		return this.id;
	}

	public void setId(BuyOrderDetailPK id) {
		this.id = id;
	}

	public BigDecimal getQuantity() {
		return this.quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BuyOrder getBuyOrder() {
		return this.buyOrder;
	}

	public void setBuyOrder(BuyOrder buyOrder) {
		this.buyOrder = buyOrder;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}