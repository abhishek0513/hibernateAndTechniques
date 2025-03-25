package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setBrand("Mac");
        l1.setRam(16);
        l1.setModel("Air");
        Person person = new Person();
        person.setId(1);
        person.setTech("Java");
        person.setName("John");
        person.setLaptop(l1);
        //Better practice
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(org.example.Person.class)
                .buildSessionFactory();
        Session sc = sf.openSession();

        //Updade the a record from database;
        Transaction tc = sc.beginTransaction();
        sc.persist(person);
        tc.commit();
        sf.close();
        System.out.println(person);
    }
}