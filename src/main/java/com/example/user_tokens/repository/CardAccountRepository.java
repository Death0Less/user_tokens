package com.example.user_tokens.repository;

import com.example.user_tokens.dto.response.CardAccountResponse;
import com.example.user_tokens.model.CardAccount;
import com.example.user_tokens.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardAccountRepository extends JpaRepository<CardAccount, Long> {

    List<CardAccount> findAllByEmployee(Employee employee);
}
