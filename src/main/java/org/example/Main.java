package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setsName("Josh");
        s1.setRollNo(104);
        s1.setMark(87);
//        SessionFactory sf = cfg.buildSessionFactory();
        //Better practice
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(org.example.Student.class)
                .buildSessionFactory();
        Session sc = sf.openSession();
        Transaction transaction = sc.beginTransaction();
        //better practice
        sc.persist(s1);
        transaction.commit();
        sf.close();
        System.out.println(s1);

    }
}