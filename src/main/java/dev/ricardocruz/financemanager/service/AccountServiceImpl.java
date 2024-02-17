package dev.ricardocruz.financemanager.service;

import dev.ricardocruz.financemanager.dto.AccountCreationRequest;
import dev.ricardocruz.financemanager.entity.Account;
import dev.ricardocruz.financemanager.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(AccountCreationRequest request) {
        Account newAccount = new Account();
        newAccount.setAccountName(request.getAccountName());
        newAccount.setAccountBalance(request.getAccountBalance());
        return accountRepository.save(newAccount);
    }
}
