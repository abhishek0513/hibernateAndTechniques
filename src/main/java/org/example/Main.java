package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setsName("Phill");
        s1.setRollNo(102);
        s1.setMark(60);
//        SessionFactory sf = cfg.buildSessionFactory();
        //Better practice
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(org.example.Student.class)
                .buildSessionFactory();
        Session sc = sf.openSession();

        //Updade the a record from database;
        Transaction tc = sc.beginTransaction();
        sc.remove(s1);
        tc.commit();
        sc.close();
        sf.close();
        System.out.println(s1);
    }
}