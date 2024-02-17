package dev.ricardocruz.financemanager.service;

import dev.ricardocruz.financemanager.dto.AccountCreationRequest;
import dev.ricardocruz.financemanager.entity.Account;
import org.springframework.stereotype.Service;

public interface AccountService {
    Account createAccount(AccountCreationRequest request);
}
