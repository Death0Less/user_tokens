package com.example.user_tokens.dto.request;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequest {

    private String name;

    private LocalDateTime creationDate;

}
