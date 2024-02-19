package dev.ricardocruz.financemanager.service;

import dev.ricardocruz.financemanager.dto.AccountDto;
import dev.ricardocruz.financemanager.model.AccountResponse;

public interface AccountService {
    AccountResponse createAccount(AccountDto accountDto);
}
