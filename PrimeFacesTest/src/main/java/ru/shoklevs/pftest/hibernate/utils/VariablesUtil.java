package ru.shoklevs.pftest.hibernate.utils;

import org.hibernate.Session;

import ru.shoklevs.pftest.model.AppSettings;

public class VariablesUtil {
	public static final String __XML_FILE_PATH = "jibx.xml.path";

	public static final String __WS_ENDPOINT_PORT = "ws.endpoint.url";
	
	public static String getValue(String name) {
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		AppSettings appSettigs = session.get(AppSettings.class, name);
		
		return appSettigs.getValue();
	}
}
