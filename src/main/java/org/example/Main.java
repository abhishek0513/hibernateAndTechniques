package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setLid(101);
        l1.setBrand("Mac");
        l1.setRam(16);
        l1.setModel("Air");

        Laptop l2 = new Laptop();
        l2.setLid(102);
        l2.setBrand("Dell");
        l2.setRam(15);
        l2.setModel("Latitude");


        Laptop l3 = new Laptop();
        l3.setLid(103);
        l3.setBrand("Hp");
        l3.setRam(8);
        l3.setModel("easy");


        Person person = new Person();
        person.setId(1);
        person.setTech("Java");
        person.setName("John");
        person.setLaptop(Arrays.asList(l1, l3));
        Person person2 = new Person();
        person2.setId(2);
        person2.setTech("Python");
        person2.setName("Linus");
        person2.setLaptop(Arrays.asList(l1, l2, l3));

        l3.setPerson(Arrays.asList(person2,person));
        l2.setPerson(Arrays.asList(person2));
        l1.setPerson(Arrays.asList(person));


        //Better practice
        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(org.example.Person.class)
                .addAnnotatedClass(org.example.Laptop.class)
                .buildSessionFactory();
        Session sc = sf.openSession();

        //Updade the a record from database;
        Transaction tc = sc.beginTransaction();
        sc.persist(l1);
        sc.persist(l2);
        sc.persist(l3);
        sc.persist(person);
        sc.persist(person2);
        tc.commit();
        sf.close();
//        System.out.println(person);
    }
}