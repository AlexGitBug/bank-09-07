package com.dmdev.entity.client;


import com.dmdev.entity.client.enums.Card;
import com.dmdev.entity.client.enums.Currency;
import com.dmdev.entity.client.enums.Status;
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
@Table(name = "payment_card", schema = "bank")
public class PaymentCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    private Card card;

    @Column(name = "expire_date")
    private LocalDate expireDate;

    @Column(name = "status_card")
    private Status status;

    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_account_id")
    private ClientAccount clientAccount;
}
