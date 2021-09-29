package com.example.user_tokens.dto.response;

import com.example.user_tokens.model.Status;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {

    private long id;

    private String firstName;

    private String lastName;

    private String patronymic;

    private String idNumber;

    private Date birthday;

    private Status status;
}
