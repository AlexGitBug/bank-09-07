package com.dmdev;

import com.dmdev.entity.*;
import com.dmdev.entity.client.Client;
import com.dmdev.entity.client.ClientAccount;
import com.dmdev.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.time.LocalDate;

public class HibernateRunner {

    public static void main(String[] args) throws SQLException {

//        Company company = Company.builder()
//                .name("Amazon")
//                .build();
//
//        User user = User.builder()
//                .username("petr1@gmail.com")
//                .personalInfo(PersonalInfo.builder()
//                        .lastname("Petrov")
//                        .firstname("Petr")
//                        .birthDate(new Birthday(LocalDate.of(2000, 1, 19)))
//                        .build())
////                    .birthDate(new Birthday(LocalDate.of(2000, 1, 19)))
//                .company(company)
//                .build();
//
        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//
////            User user1 = session.get(User.class, 1L);
////            session.evict(user1);
//
////
//            session.save(user);
////            session.save(user);
//
//            session.getTransaction().commit();



            Client client = Client.builder()
                    .lastname("test")
                    .firstname("test")
                    .email("test")
                    .birthDate(LocalDate.of(1, 1, 1))
                    .password("test")
                    .telephone("test")
                    .role(Role.ADMIN)
                    .build();

            ClientAccount clientAccount = ClientAccount.builder()
                    .client(client)
                    .amount(100L)
                    .build();


            try (Session session1 = sessionFactory.openSession()) {
                session1.beginTransaction();


                client.addClientAccount(clientAccount);
                session1.save(client);

                session1.getTransaction().commit();
//            }
            }
        }
    }
}

