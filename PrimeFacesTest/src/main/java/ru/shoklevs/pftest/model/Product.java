package ru.shoklevs.pftest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the PRODUCT database table.
 * 
 */
@Entity
@Table(name="PRODUCT")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=1024)
	private String serial;

	@Lob
	private String description;

	private Timestamp manufactured;

	@Column(length=1024)
	private String name;

	private BigDecimal price;

	//bi-directional many-to-one association to BuyOrderDetail
	@OneToMany(mappedBy="product")
	private List<BuyOrderDetail> buyOrderDetails;

	public Product() {
	}

	public String getSerial() {
		return this.serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getManufactured() {
		return this.manufactured;
	}

	public void setManufactured(Timestamp manufactured) {
		this.manufactured = manufactured;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<BuyOrderDetail> getBuyOrderDetails() {
		return this.buyOrderDetails;
	}

	public void setBuyOrderDetails(List<BuyOrderDetail> buyOrderDetails) {
		this.buyOrderDetails = buyOrderDetails;
	}

	public BuyOrderDetail addBuyOrderDetail(BuyOrderDetail buyOrderDetail) {
		getBuyOrderDetails().add(buyOrderDetail);
		buyOrderDetail.setProduct(this);

		return buyOrderDetail;
	}

	public BuyOrderDetail removeBuyOrderDetail(BuyOrderDetail buyOrderDetail) {
		getBuyOrderDetails().remove(buyOrderDetail);
		buyOrderDetail.setProduct(null);

		return buyOrderDetail;
	}

}