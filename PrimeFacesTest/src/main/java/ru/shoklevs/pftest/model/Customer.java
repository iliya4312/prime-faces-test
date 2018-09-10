package ru.shoklevs.pftest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@Table(name="CUSTOMER")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private long id;

	@Column(length=1024)
	private String addr;

	@Column(length=1024)
	private String name;

	//bi-directional many-to-one association to BuyOrder
	@OneToMany(mappedBy="customer")
	private List<BuyOrder> buyOrders;

	public Customer() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddr() {
		return this.addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BuyOrder> getBuyOrders() {
		return this.buyOrders;
	}

	public void setBuyOrders(List<BuyOrder> buyOrders) {
		this.buyOrders = buyOrders;
	}

	public BuyOrder addBuyOrder(BuyOrder buyOrder) {
		getBuyOrders().add(buyOrder);
		buyOrder.setCustomer(this);

		return buyOrder;
	}

	public BuyOrder removeBuyOrder(BuyOrder buyOrder) {
		getBuyOrders().remove(buyOrder);
		buyOrder.setCustomer(null);

		return buyOrder;
	}

}