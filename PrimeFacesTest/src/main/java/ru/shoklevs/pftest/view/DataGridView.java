package ru.shoklevs.pftest.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Asynchronous;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ru.shoklevs.pftest.model.BuyOrder;
import ru.shoklevs.pftest.model.BuyOrderDetail;
import ru.shoklevs.pftest.service.BuyOrderService;
import ru.shoklevs.pftest.service.DateFetchService;
import ru.shoklevs.pftest.service.ProductService;
 
@ManagedBean
@ViewScoped
public class DataGridView implements Serializable {

	private static final long serialVersionUID = -1202759213464971192L;

	private List<BuyOrder> buyOrders;
	
	private List<BuyOrderDetail> buyOrderDetails;
     
    private BuyOrder selectedBuyOrder;
    
    private BuyOrderDetail selectedBuyOrderDetail;
     
    @ManagedProperty("#{buyOrderService}")
    private BuyOrderService service;
    
    @ManagedProperty("#{productService}")
    private ProductService productService;
    
    @ManagedProperty("#{dateFetchService}")
    private DateFetchService dateFetchService;
    
    @PostConstruct
    public void init() {
    	buyOrders = service.getBuyOrders();
    }
 
    public List<BuyOrder> getBuyOrders() {
        return buyOrders;
    }
 
    public void setService(BuyOrderService service) {
        this.service = service;
    }
 
    public BuyOrder getSelectedBuyOrder() {
        return selectedBuyOrder;
    }
 
    public void setSelectedBuyOrder(BuyOrder selectedBuyOrder) {
        this.selectedBuyOrder = selectedBuyOrder;
    }

    public BuyOrderDetail getSelectedBuyOrderDetail() {
		return selectedBuyOrderDetail;
	}

    public void setSelectedBuyOrderDetail(BuyOrderDetail selectedBuyOrderDetail) {
		this.selectedBuyOrderDetail = selectedBuyOrderDetail;
	}

    public List<BuyOrderDetail> getBuyOrderDetails() {
		return buyOrderDetails;
	}

    public void setBuyOrderDetails(List<BuyOrderDetail> buyOrderDetails) {
		this.buyOrderDetails = buyOrderDetails;
	}
    
    public String updateProductsAction() {
    	getProductService().updateProductsFromXML();
    	return null;
    }

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@Asynchronous
	public DateFetchService getDateFetchService() {
		return dateFetchService;
	}
	
	public void setDateFetchService(DateFetchService dateFetchService) {
		this.dateFetchService = dateFetchService;
	}
    
}