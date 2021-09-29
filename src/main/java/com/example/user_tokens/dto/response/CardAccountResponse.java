package com.example.user_tokens.dto.response;

import com.example.user_tokens.model.Status;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardAccountResponse {

    private long id;

    private String billNumber;

    private String currency;

    private Status status;
}
