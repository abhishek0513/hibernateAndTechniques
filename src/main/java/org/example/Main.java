package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setsName("John");
        s1.setRollNo(100);
        s1.setMark(90);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(org.example.Student.class);
        cfg.configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session sc = sf.openSession();
        Transaction transaction = sc.beginTransaction();
        sc.save(s1);
        transaction.commit();
        System.out.println(s1);

    }
}