package com.example.user_tokens.service;

import com.example.user_tokens.dto.request.CardRequest;
import com.example.user_tokens.dto.response.CardResponse;
import com.example.user_tokens.mapper.CardMapper;
import com.example.user_tokens.mapper.LogicStatusMapper;
import com.example.user_tokens.model.Card;
import com.example.user_tokens.model.CardAccount;
import com.example.user_tokens.repository.CardAccountRepository;
import com.example.user_tokens.repository.CardRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;
    private final CardAccountRepository cardAccountRepository;
    private final LogicStatusMapper logicStatusMapper;

    @Transactional
    public CardResponse save(long cardAccountId, CardRequest cardRequest) {
        Card card = cardMapper.mapCardDtoToCard(cardRequest);
        CardAccount cardAccount = cardAccountRepository.findById(cardAccountId).orElseThrow(NullPointerException::new);
        card.setCardAccount(cardAccount);
        card = cardRepository.save(card);
        CardResponse cardResponse = cardMapper.mapCardToCardDto(card);
        cardResponse.setLogicStatus(logicStatusMapper.mapStatusFields(cardResponse.getLogicStatus()));
        return cardResponse;
    }

    @Transactional
    public void deleteById(long id) {
        Card card = cardRepository.findById(id).orElseThrow(NullPointerException::new);
        cardRepository.delete(card);
    }

    public CardResponse findById(long id) {
        Card card = cardRepository.findById(id).orElseThrow(NullPointerException::new);
        card.setLogicStatus(logicStatusMapper.mapStatusFields(card.getLogicStatus()));
        return cardMapper.mapCardToCardDto(card);
    }

    public List<CardResponse> findAll() {
        List<Card> cards = cardRepository.findAll();
        return logicStatusMapper.mapCardList(cardMapper.mapCardListToCardListDto(cards));
    }

    public CardResponse update(long id, CardRequest cardRequest) {
        Card card = cardRepository.findById(id).orElseThrow(NullPointerException::new);
        updateCardFromDto(cardRequest, card);
        card = cardRepository.save(card);
        return cardMapper.mapCardToCardDto(card);
    }

    private void updateCardFromDto(CardRequest cardRequest, Card card) {
        if (cardRequest.getLogicStatus() != null) {
            card.setLogicStatus(logicStatusMapper.mapStatusFields(cardRequest.getLogicStatus()));
        }
        if (cardRequest.getCardNumber() != null) {
            card.setCardNumber(cardRequest.getCardNumber());
        }
        if (cardRequest.getCardFirstName() != null) {
            card.setCardFirstName(cardRequest.getCardFirstName());
        }
        if (cardRequest.getCardLastName() != null) {
            card.setCardLastName(cardRequest.getCardLastName());
        }
    }

}
