package com.example.user_tokens.dto.request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardRequest {

    private String logicStatus;

    private String cardNumber;

    private String cardFirstName;

    private String cardLastName;
}
