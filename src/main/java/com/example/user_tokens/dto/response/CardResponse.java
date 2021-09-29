package com.example.user_tokens.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardResponse {

    private long id;

    private String logicStatus;

    private String cardNumber;

    private String cardFirstName;

    private String cardLastName;
}
