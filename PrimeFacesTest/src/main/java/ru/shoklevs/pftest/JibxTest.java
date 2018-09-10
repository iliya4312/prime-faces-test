package ru.shoklevs.pftest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import org.hibernate.Session;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;

import ru.shoklevs.pftest.hibernate.utils.HibernateSessionFactory;
import ru.shoklevs.pftest.jibx.ProductContainer;
import ru.shoklevs.pftest.model.Product;

public class JibxTest {
	
	public String marshalProduct(ProductContainer product){
		try {
			IBindingFactory bfact = BindingDirectory.getFactory(Product.class);
			IMarshallingContext mctx = bfact.createMarshallingContext();
			mctx.setIndent(2);
			StringWriter stringWriter = new StringWriter();
			mctx.setOutput(stringWriter);
			mctx.marshalDocument(product, "UTF-8", false);
			String output = stringWriter.toString();
			return output;
		} catch (JiBXException e) {
			e.printStackTrace();
		}
		return null;
	}

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
	
	private static void write() {
		
		JibxTest jibxTest = new JibxTest();
//		jibxTest.unMarshalEmployee(inputXml);
		
		Session session = HibernateSessionFactory.getSessionFactory().openSession();
		List<Product> result = session.createCriteria(Product.class).list();
		ProductContainer pc = new ProductContainer();
		pc.setProducts(result);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("c:/projects/products.xml"));
			
			writer.write(jibxTest.marshalProduct(pc));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static ProductContainer read() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("c:/projects/products.xml"));
		    StringBuilder builder = new StringBuilder();
		    String currentLine = reader.readLine();
		    while (currentLine != null) {
		        builder.append(currentLine);
		        currentLine = reader.readLine();
		    }
		     
		    reader.close();
			ProductContainer pc = unMarshalProduct(new String(builder));
			System.out.println(pc.getProducts().get(0).getName());
		}
		catch(IOException e) {
			e.printStackTrace();
			
		}
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void main(String args[]){
		write();
		read();
	}
}