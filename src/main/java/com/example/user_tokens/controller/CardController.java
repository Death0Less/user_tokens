package com.example.user_tokens.controller;

import com.example.user_tokens.dto.request.CardRequest;
import com.example.user_tokens.dto.response.CardResponse;
import com.example.user_tokens.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;


    @PostMapping
    public CardResponse save(long cardAccountId, @RequestBody CardRequest cardRequest) {
        return cardService.save(cardAccountId, cardRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        cardService.deleteById(id);
    }

    @GetMapping("/{id}")
    public CardResponse findById(@PathVariable long id) {
        return cardService.findById(id);
    }

    @GetMapping
    public List<CardResponse> findAll() {
        return cardService.findAll();
    }

    @PutMapping("/{id}")
    public CardResponse update(@PathVariable long id, @RequestBody CardRequest cardRequest) {
        return cardService.update(id, cardRequest);
    }

}
