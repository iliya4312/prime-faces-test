package ru.shoklevs.pftest.service;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;

import ru.shoklevs.pftest.hibernate.utils.HibernateSessionFactory;
import ru.shoklevs.pftest.hibernate.utils.VariablesUtil;
import ru.shoklevs.pftest.jibx.ProductContainer;
import ru.shoklevs.pftest.model.Product;

@ManagedBean(name = "productService")
@ApplicationScoped
public class ProductService {

	public static ProductContainer unMarshalProduct(String inputXml){
		try {
			IBindingFactory bfact = BindingDirectory.getFactory(Product.class);
			IUnmarshallingContext uctx = bfact.createUnmarshallingContext();
			StringReader stringReader = new StringReader(inputXml);
			ProductContainer product  = (ProductContainer) uctx.unmarshalDocument(stringReader, null);
			return product;
		} catch (JiBXException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateProductsFromXML() {
		BufferedReader reader = null;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		session.beginTransaction();
		try {
			reader = new BufferedReader(new FileReader(VariablesUtil.getValue(VariablesUtil.__XML_FILE_PATH)));
		    StringBuilder builder = new StringBuilder();
		    String currentLine = reader.readLine();
		    while (currentLine != null) {
		        builder.append(currentLine);
		        currentLine = reader.readLine();
		    }

		    reader.close();
			ProductContainer pc = unMarshalProduct(new String(builder));
			for(Product p:pc.getProducts()) {
				session.saveOrUpdate(p);
			}
			session.getTransaction().commit();
		}
		catch(IOException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			
		}
		finally {
			try {
				session.close();
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}

}
