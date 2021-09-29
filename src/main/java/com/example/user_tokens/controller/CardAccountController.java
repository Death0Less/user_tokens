package com.example.user_tokens.controller;

import com.example.user_tokens.dto.request.CardAccountRequest;
import com.example.user_tokens.dto.response.CardAccountResponse;
import com.example.user_tokens.service.CardAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cardAccounts")
public class CardAccountController {

    private final CardAccountService cardAccountService;

    @PostMapping
    public CardAccountResponse save(long employeeId, @RequestBody CardAccountRequest cardAccountRequest) {
        return cardAccountService.save(employeeId, cardAccountRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        cardAccountService.deleteById(id);
    }

    @GetMapping("/{id}")
    public CardAccountResponse findById(@PathVariable long id) {
        return cardAccountService.findById(id);
    }

    @GetMapping
    public List<CardAccountResponse> findAll() {
        return cardAccountService.findAll();
    }

    @PutMapping("/{id}")
    public CardAccountResponse cardAccountResponse(@PathVariable long id, @RequestBody CardAccountRequest cardAccountRequest) {
        return cardAccountService.update(id, cardAccountRequest);
    }
}