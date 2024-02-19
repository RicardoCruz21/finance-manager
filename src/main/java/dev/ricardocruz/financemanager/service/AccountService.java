package dev.ricardocruz.financemanager.service;

import dev.ricardocruz.financemanager.dto.AccountDto;
import dev.ricardocruz.financemanager.model.AccountListResponse;
import dev.ricardocruz.financemanager.model.AccountResponse;

public interface AccountService {
    AccountListResponse getAllAccounts();
    AccountResponse getAccountById(Long id);
    AccountResponse createAccount(AccountDto accountDto);
    AccountResponse updateAccount(Long id, AccountDto accountDto);
    AccountResponse deleteAccount(Long id);
}
