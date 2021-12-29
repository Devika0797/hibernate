package com.hibernate_app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class MainApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        //create
        Session session = null;
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product product = new Product("Apple",70);
        System.out.println(product);
        session.save(product);
        System.out.println(product);
        session.getTransaction().commit();

        sessionFactory.close();
    }
}
