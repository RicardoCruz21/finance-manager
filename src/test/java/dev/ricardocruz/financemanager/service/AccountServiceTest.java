package dev.ricardocruz.financemanager.service;

import dev.ricardocruz.financemanager.dto.AccountCreationRequest;
import dev.ricardocruz.financemanager.entity.Account;
import dev.ricardocruz.financemanager.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

public class AccountServiceTest {

    private AccountRepository accountRepository;
    private AccountService accountService;

    @BeforeEach
    public void setup() {
        accountRepository = Mockito.mock(AccountRepository.class);
        accountService = new AccountServiceImpl(accountRepository);
    }

    @Test
    public void testCreateAccount() {
        AccountCreationRequest request = new AccountCreationRequest();
        request.setAccountName("Bills");
        request.setAccountBalance(new BigDecimal("1945.67"));

        Account mockAccount = new Account(1L, request.getAccountName(), request.getAccountBalance());

        Mockito.when(accountRepository.save(Mockito.any(Account.class))).thenReturn(mockAccount);

        Account createdAccount = accountService.createAccount(request);

        Assertions.assertEquals(mockAccount, createdAccount);
    }
}
