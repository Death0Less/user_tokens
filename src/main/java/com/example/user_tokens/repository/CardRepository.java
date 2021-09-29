package com.example.user_tokens.repository;

import com.example.user_tokens.dto.response.CardResponse;
import com.example.user_tokens.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {

    List<Card> findAllByCardAccountId(long cardAccountId);
}
