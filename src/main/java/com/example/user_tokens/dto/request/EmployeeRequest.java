package com.example.user_tokens.dto.request;

import com.example.user_tokens.model.Status;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {

    private String firstName;

    private String lastName;

    private String patronymic;

    private String idNumber;

    private Date birthday;

    private Status status;
}
