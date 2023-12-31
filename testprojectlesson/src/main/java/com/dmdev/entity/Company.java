package com.dmdev.entity;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@ToString(exclude = "users")
@EqualsAndHashCode(exclude = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Builder.Default
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();

    public void addUser(User user) {
        users.add(user);
        user.setCompany(this);
    }
}
