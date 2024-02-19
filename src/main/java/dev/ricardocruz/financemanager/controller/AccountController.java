package dev.ricardocruz.financemanager.controller;

import dev.ricardocruz.financemanager.dto.AccountDto;
import dev.ricardocruz.financemanager.model.AccountListResponse;
import dev.ricardocruz.financemanager.model.AccountResponse;
import dev.ricardocruz.financemanager.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    public ResponseEntity<AccountListResponse> getAllAccounts() {
        AccountListResponse accountListResponse = accountService.getAllAccounts();
        return ResponseEntity.status(HttpStatus.OK).body(accountListResponse);
    }

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@RequestBody AccountDto accountDto) {
        AccountResponse accountResponse = accountService.createAccount(accountDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(accountResponse);
    }
}
