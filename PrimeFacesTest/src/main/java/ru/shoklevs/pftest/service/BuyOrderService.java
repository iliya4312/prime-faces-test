package ru.shoklevs.pftest.service;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import ru.shoklevs.pftest.hibernate.utils.HibernateSessionFactory;
import ru.shoklevs.pftest.model.BuyOrder;
import ru.shoklevs.pftest.model.BuyOrderDetail;

@ManagedBean(name = "buyOrderService")
@ApplicationScoped
public class BuyOrderService {
	public List<BuyOrder> getBuyOrders() {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		List<BuyOrder> result = session.createCriteria(BuyOrder.class).list();
		
		return result;
	}

}
