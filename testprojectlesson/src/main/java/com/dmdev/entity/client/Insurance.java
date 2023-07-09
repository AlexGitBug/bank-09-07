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
@Table(name = "insurance", schema = "bank")
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "insurance_number")
    private String insuranceNumber;

    @Column(name = "current_balance")
    private String currentBalance;

    @Column(name = "status_insurance_number")
    private String statusInsuranceNumber;
}
