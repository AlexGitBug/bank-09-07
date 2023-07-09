package com.dmdev.entity.client;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString(exclude = {"transactionProcessings", "payments", "paymentCards"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "client_account", schema = "bank")
public class ClientAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @Builder.Default
    @OneToMany(mappedBy = "clientAccount")
    List<TransactionProcessing> transactionProcessings = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "clientAccount")
    List <Payment> payments = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "clientAccount")
    List<PaymentCard> paymentCards = new ArrayList<>();

    public void addPayment(Payment payment) {
        payments.add(payment);
        payment.setClientAccount(this);
    }

    public void addPaymentCard(PaymentCard paymentCard) {
        paymentCards.add(paymentCard);
        paymentCard.setClientAccount(this);
    }
}