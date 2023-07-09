package com.dmdev;

import com.dmdev.entity.Company;
import com.dmdev.entity.User;
import com.dmdev.util.HibernateUtil;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class HibernateRunnerTest {

    @Test
    void checkOrphanremoval() {
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            var company = session.get(Company.class, 1);
            company.getUsers().removeIf(user -> user.getId().equals(1));

            session.getTransaction().commit();
        }
    }

    @Test
    void checkLazyInitialization() {
        Company company = null;
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            company = session.get(Company.class, 1);

            session.getTransaction().commit();
        }
        Set<User> users = company.getUsers();
        System.out.println(users.size());
    }

    @Test
    void deleteCompany() {

        @Cleanup SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();

        session.beginTransaction();

        var company = session.get(Company.class, 4);
        session.delete(company);


        session.getTransaction().commit();
    }


    @Test
    void addUserToNewCompany() {

        @Cleanup SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();

        session.beginTransaction();

        Company company = Company.builder().name("Facebook").build();
        User user = User.builder().username("sveta@gmail.com").build();

        company.addUser(user);

        session.save(company);

        session.getTransaction().commit();
    }

    @Test
    void oneToMany() {

        @Cleanup SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup Session session = sessionFactory.openSession();

        session.beginTransaction();

        Company company = session.get(Company.class, 1);
        System.out.println(company.getUsers());

        session.getTransaction().commit();

    }
}