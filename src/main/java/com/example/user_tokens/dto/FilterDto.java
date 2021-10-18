package com.example.user_tokens.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class FilterDto {

    private Date birthDateLess;

    private Date birthDateMore;

    private String idNumber;
}
