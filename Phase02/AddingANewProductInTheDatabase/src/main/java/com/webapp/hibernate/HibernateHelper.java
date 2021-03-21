package com.webapp.hibernate;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import com.webapp.pojo.Product;

import javassist.convert.Transformer;

public class HibernateHelper {
	
	public void addProduct(HttpServletResponse response, HttpServletRequest request, Product product) throws ServletException, IOException {
		SessionFactory factory = createSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(product);
		
		transaction.commit();
		session.close();
		
		request.getRequestDispatcher("ViewProduct.jsp").include(request, response);
	}
	
	public void getProducts(HttpServletRequest request) {
		SessionFactory factory = createSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Product");
		List<Product> list = (List<Product>) query.list();
		
		transaction.commit();
		session.close();
		
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("productList", list);
	}

	private SessionFactory createSessionFactory() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(com.webapp.pojo.Product.class);
	
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
	
		return factory;
	}
}
