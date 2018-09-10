package ru.shoklevs.pftest;

import java.util.List;

import org.hibernate.Session;

import ru.shoklevs.pftest.hibernate.utils.HibernateSessionFactory;
import ru.shoklevs.pftest.hibernate.utils.VariablesUtil;
import ru.shoklevs.pftest.model.BuyOrder;
import ru.shoklevs.pftest.model.BuyOrderDetail;
import utils.system;

public class Test {
	public static void main(String ... args) {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		List<BuyOrder> result = session.createCriteria(BuyOrder.class).list();
		List<BuyOrderDetail> dets = result.get(0).getBuyOrderDetails();
		for(BuyOrder bo:result) {
			System.out.print(bo.getId() + " ( ");
			for(BuyOrderDetail bod:bo.getBuyOrderDetails()) {
				System.out.print("(" + bod.getId().getPosition() + ") ");
			}
			System.out.print(")");
			System.out.println();
			
		}
		System.out.println(VariablesUtil.getValue(VariablesUtil.__XML_FILE_PATH));
		System.out.println(VariablesUtil.getValue(VariablesUtil.__WS_ENDPOINT_PORT));
	}
}
