package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {


        //Better practice
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(org.example.Laptop.class)
                .buildSessionFactory();
        Session sc = sf.openSession();
        //SQL :: select * from table where ram = 16
        //HQL :: From Laptop where ram = 16;

        String brand = "MAC";
        Query query = sc.createQuery("select model from Laptop where brand Ilike ?1");
        query.setParameter(1, brand);
        List<String> laptop = query.getResultList();
//        Laptop l1 = sc.get(Laptop.class, 103);
        System.out.println(laptop);

        sc.close();
        sf.close();
    }
}