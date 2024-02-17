package dev.ricardocruz.financemanager.service;

import dev.ricardocruz.financemanager.dto.AccountCreationRequest;
import dev.ricardocruz.financemanager.entity.Account;
import dev.ricardocruz.financemanager.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;
    @InjectMocks
    private AccountServiceImpl accountService;

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
