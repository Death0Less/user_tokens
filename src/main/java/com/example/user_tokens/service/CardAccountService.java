package com.example.user_tokens.service;

import com.example.user_tokens.dto.request.CardAccountRequest;
import com.example.user_tokens.dto.response.CardAccountResponse;
import com.example.user_tokens.mapper.CardAccountMapper;
import com.example.user_tokens.model.CardAccount;
import com.example.user_tokens.model.Employee;
import com.example.user_tokens.repository.CardAccountRepository;
import com.example.user_tokens.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CardAccountService {

    private final CardAccountRepository cardAccountRepository;
    private final CardAccountMapper cardAccountMapper;
    private final EmployeeRepository employeeRepository;


    @Transactional
    public CardAccountResponse save(long employeeId, CardAccountRequest cardAccountRequest) {
        CardAccount cardAccount = cardAccountMapper.mapCardAccountDtoToCardAccount(cardAccountRequest);
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(NullPointerException::new);
        cardAccount.setEmployee(employee);
        cardAccountRepository.save(cardAccount);
        return cardAccountMapper.mapCardAccountToCardAccountDto(cardAccount);
    }

    @Transactional
    public void deleteById(long id) {
        CardAccount cardAccount = cardAccountRepository.findById(id).orElseThrow(NullPointerException::new);
        cardAccountRepository.deleteById(id);
    }

    public CardAccountResponse findById(long id) {
        CardAccount cardAccount = cardAccountRepository.findById(id).orElseThrow(NullPointerException::new);
        return cardAccountMapper.mapCardAccountToCardAccountDto(cardAccount);
    }

    public List<CardAccountResponse> findAll() {
        List<CardAccount> cardAccountList = cardAccountRepository.findAll();
        return cardAccountMapper.mapCardAccountListToCardAccountListDto(cardAccountList);
    }

    public List<CardAccountResponse> findAllByEmployee(long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(NullPointerException::new);
        List<CardAccount> cardAccountList = cardAccountRepository.findAllByEmployee(employee);
        return cardAccountMapper.mapCardAccountListToCardAccountListDto(cardAccountList);
    }

    public CardAccountResponse update(long id, CardAccountRequest cardAccountRequest) {
        CardAccount cardAccount = cardAccountRepository.findById(id).orElseThrow(NullPointerException::new);
        updateCardAccountFromDto(cardAccountRequest, cardAccount);
        cardAccount = cardAccountRepository.save(cardAccount);
        return cardAccountMapper.mapCardAccountToCardAccountDto(cardAccount);
    }

    public void updateCardAccountFromDto(CardAccountRequest cardAccountRequest, CardAccount cardAccount) {
        if (cardAccountRequest.getBillNumber() != null) {
            cardAccount.setBillNumber(cardAccountRequest.getBillNumber());
        }
        if (cardAccountRequest.getCurrency() != null) {
            cardAccount.setCurrency(cardAccountRequest.getCurrency());
        }
        if (cardAccountRequest.getStatus() != null) {
            cardAccount.setStatus(cardAccountRequest.getStatus());
        }
    }
}
