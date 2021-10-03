package com.example.user_tokens.mapper;

import com.example.user_tokens.dto.response.CardResponse;
import com.example.user_tokens.properties.LogicStatusProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LogicStatusMapper {

    private final LogicStatusProperties logicStatusProperties;

    public String mapStatusFields(String logicStatus) {
        String status = logicStatusProperties.getLogicStatuses().get(logicStatus);
        String defaultMessage = logicStatusProperties.getDefaultMessage();

        return status != null ? status : defaultMessage;
    }

    public List<CardResponse> mapCardList(List<CardResponse> cardList) {
        for (CardResponse cardResponse : cardList) {
           cardResponse.setLogicStatus(mapStatusFields(cardResponse.getLogicStatus()));
        }
       return cardList;
    }
}
