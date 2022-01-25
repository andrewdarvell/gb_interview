package ru.darvell.gb.interview.hibernate.students.component;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryManager {

    private HibernateSessionFactoryManager(){}

    public static final SessionFactory sessionFactory = new Configuration()
            .configure("config/hibernate.cfg.xml")
            .buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
