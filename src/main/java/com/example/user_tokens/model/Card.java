package com.example.user_tokens.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cards")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String logicStatus;

    private String cardNumber;

    private String cardFirstName;

    private String cardLastName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CardAccount cardAccount;
}
