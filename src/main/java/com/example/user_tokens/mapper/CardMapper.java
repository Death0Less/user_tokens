package com.example.user_tokens.mapper;

import com.example.user_tokens.dto.request.CardRequest;
import com.example.user_tokens.dto.response.CardResponse;
import com.example.user_tokens.model.Card;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
public class CardMapper {

    public Card mapCardDtoToCard(CardRequest cardRequest) {
        return Card.builder()
                .logicStatus(cardRequest.getLogicStatus())
                .cardNumber(cardRequest.getCardNumber())
                .cardFirstName(cardRequest.getCardFirstName())
                .cardLastName(cardRequest.getCardLastName())
                .build();
    }

    public CardResponse mapCardToCardDto(Card card) {
        return CardResponse.builder()
                .id(card.getId())
                .logicStatus(card.getLogicStatus())
                .cardNumber(card.getCardNumber())
                .cardFirstName(card.getCardFirstName())
                .cardLastName(card.getCardLastName())
                .build();
    }

    public List<CardResponse> mapCardListToCardListDto(List<Card> cardList) {
        List<CardResponse> cardResponseList = new ArrayList<>();
        for (Card card : cardList) {
            CardResponse cardResponse = mapCardToCardDto(card);
            cardResponseList.add(cardResponse);
        }
        return  cardResponseList;
    }
}
