package com.example.user_tokens.mapper;

import com.example.user_tokens.dto.request.CardAccountRequest;
import com.example.user_tokens.dto.response.CardAccountResponse;
import com.example.user_tokens.model.CardAccount;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
public class CardAccountMapper {

    public CardAccount mapCardAccountDtoToCardAccount(CardAccountRequest cardAccountRequest) {
        return CardAccount.builder()
                .billNumber(cardAccountRequest.getBillNumber())
                .currency(cardAccountRequest.getCurrency())
                .status(cardAccountRequest.getStatus())
                .build();
    }

    public CardAccountResponse mapCardAccountToCardAccountDto(CardAccount cardAccount) {
        return CardAccountResponse.builder()
                .id(cardAccount.getId())
                .billNumber(cardAccount.getBillNumber())
                .currency(cardAccount.getCurrency())
                .status(cardAccount.getStatus())
                .build();
    }

    public List<CardAccountResponse>  mapCardAccountListToCardAccountListDto(List<CardAccount> cardAccountList) {
        List<CardAccountResponse> cardAccountResponseList = new ArrayList<>();
        for (CardAccount cardAccount : cardAccountList) {
            CardAccountResponse cardAccountResponse = mapCardAccountToCardAccountDto(cardAccount);
            cardAccountResponseList.add(cardAccountResponse);
        }
        return cardAccountResponseList;
    }
}
