package com.dmdev.entity.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "transaction_processing", schema = "bank")
public class TransactionProcessing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_account_id")
    private ClientAccount clientAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    private String requisite;

    @Column(name = "transfer_sum")
    private Long transferSum;

    @Column(name = "created_at")
    private LocalDate createdAt;

    public void setClientAccount(ClientAccount clientAccount) {
        this.clientAccount = clientAccount;
        this.clientAccount.getTransactionProcessings().add(this);
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
        this.payment.getTransactionProcessings().add(this);
    }
}
