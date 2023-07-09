package com.dmdev.entity.client;

import com.dmdev.entity.Role;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString(exclude = "clientAccounts")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "client", schema = "bank")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private String email;
    private String telephone;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
    @Builder.Default
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<ClientAccount> clientAccounts = new ArrayList<>();

    public void addClientAccount(ClientAccount clientAccount) {
        clientAccounts.add(clientAccount);
        clientAccount.setClient(this);

    }


}
