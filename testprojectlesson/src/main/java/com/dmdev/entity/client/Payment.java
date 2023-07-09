package com.dmdev.entity.client;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString(exclude = {"insurancePayments", "telephonePayments", "transactionProcessings"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "payment", schema = "bank")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_account_id")
    private ClientAccount clientAccount;

    @Builder.Default
    @OneToMany(mappedBy = "payment")
    List<InsurancePayment> insurancePayments = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "payment")
    List<TelephonePayment> telephonePayments = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "payment")
    List<TransactionProcessing> transactionProcessings = new ArrayList<>();


    public void addInsurancePayment(InsurancePayment insurancePayment) {
        insurancePayments.add(insurancePayment);
        insurancePayment.setPayment(this);
    }
    public void addTelephonePayment(TelephonePayment telephonePayment) {
        telephonePayments.add(telephonePayment);
        telephonePayment.setPayment(this);
    }


}
