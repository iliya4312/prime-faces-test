package ru.shoklevs.pftest.service;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import ru.shoklevs.pftest.proxy.DateServiceProxy;

@ManagedBean(name = "dateFetchService")
@ApplicationScoped
public class DateFetchService {
	public String getDate() {
		DateServiceProxy dsProxy = null;
		Calendar calendar = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		System.out.println();
		try {
			dsProxy = new DateServiceProxy();
			calendar = dsProxy.getDate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(calendar == null) {
			return "N/A";
		}
		else {
			dateFormat.setTimeZone(calendar.getTimeZone());
			return dateFormat.format(calendar.getTime());
		}
	}
}
