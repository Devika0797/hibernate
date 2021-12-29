package com.hibernate_app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class MainApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()//.configure("hibernate.properties")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(ShopCart.class)
                .buildSessionFactory();

        Session session = null;
        session= sessionFactory.getCurrentSession();
        session.beginTransaction();
        //Product product = new Product("CANDY", 10);
//        System.out.println(product);
//        session.save(product);
//        System.out.println(product);
        session.getTransaction().commit();
        sessionFactory.close();
    }
}
