package com.example.user_tokens.dto.request;

import com.example.user_tokens.model.Status;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardAccountRequest {

    private String billNumber;

    private String currency;

    private Status status;
}
