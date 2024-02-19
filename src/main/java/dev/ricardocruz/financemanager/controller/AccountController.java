package dev.ricardocruz.financemanager.controller;

import dev.ricardocruz.financemanager.dto.AccountDto;
import dev.ricardocruz.financemanager.model.AccountResponse;
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
    public ResponseEntity<AccountResponse> createAccount(@RequestBody AccountDto accountDto) {
        AccountResponse accountResponse = accountService.createAccount(accountDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(accountResponse);
    }
}
