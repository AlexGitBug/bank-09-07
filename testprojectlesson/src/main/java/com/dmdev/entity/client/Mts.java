package com.dmdev.entity.client;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "mts", schema = "bank")
public class Mts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "telephone_number")
    private String telephone_number;
    @Column(name = "current_balance")
    private Long currentBalance;
    @Column(name = "status_telephone_number")
    private String statusTelephoneNumber;
}
