package ru.shoklevs.pftest.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Formula;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the BUY_ORDER database table.
 * 
 */
@Entity
@Table(name="BUY_ORDER")
@NamedQuery(name="BuyOrder.findAll", query="SELECT b FROM BuyOrder b")
public class BuyOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long id;

	private Timestamp created;

	@Column(name="TOTAL_PRICE")
	@Formula("(select sum(d.quantity*p.price) from buy_order b left join buy_order_detail d on d.fk_buy_order = b.id left join product p on d.fk_product = p.serial where b.id = id )")
	private BigDecimal totalPrice;

	//bi-directional many-to-one association to Customer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FK_CUSTOMER")
	private Customer customer;

	//bi-directional many-to-one association to BuyOrderDetail
	@OneToMany(mappedBy="buyOrder")
	@OrderBy("id.position ASC")
	private List<BuyOrderDetail> buyOrderDetails;

	public BuyOrder() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public BigDecimal getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<BuyOrderDetail> getBuyOrderDetails() {
		return this.buyOrderDetails;
	}

	public void setBuyOrderDetails(List<BuyOrderDetail> buyOrderDetails) {
		this.buyOrderDetails = buyOrderDetails;
	}

	public BuyOrderDetail addBuyOrderDetail(BuyOrderDetail buyOrderDetail) {
		getBuyOrderDetails().add(buyOrderDetail);
		buyOrderDetail.setBuyOrder(this);

		return buyOrderDetail;
	}

	public BuyOrderDetail removeBuyOrderDetail(BuyOrderDetail buyOrderDetail) {
		getBuyOrderDetails().remove(buyOrderDetail);
		buyOrderDetail.setBuyOrder(null);

		return buyOrderDetail;
	}

}