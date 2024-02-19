package dev.ricardocruz.financemanager.controller;

import dev.ricardocruz.financemanager.dto.AccountCreationRequest;
import dev.ricardocruz.financemanager.entity.Account;
import dev.ricardocruz.financemanager.model.FinanceManagerResponse;
import dev.ricardocruz.financemanager.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<FinanceManagerResponse<Account>> createNewAccount(@RequestBody AccountCreationRequest request) {
        Account createdAccount = accountService.createAccount(request);
        if (createdAccount != null) {
            return new ResponseEntity<>(FinanceManagerResponse.success(createdAccount), HttpStatus.CREATED);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error: bad request submitted");
        }
    }
}
