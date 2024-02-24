package dev.ricardocruz.financemanager.service;

import dev.ricardocruz.financemanager.dto.AccountDto;
import dev.ricardocruz.financemanager.entity.Account;
import dev.ricardocruz.financemanager.model.AccountResponse;
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
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountName("Bills");
        accountDto.setAccountBalance(new BigDecimal("1945.67"));

        Account mockAccount = new Account(1L, accountDto.getAccountName(), accountDto.getAccountBalance());

        Mockito.when(accountRepository.save(Mockito.any(Account.class))).thenReturn(mockAccount);

        AccountResponse accountResponse = accountService.createAccount(accountDto);

        Assertions.assertEquals(mockAccount.getId(), accountResponse.getAccount().getId());
        Assertions.assertEquals(mockAccount.getAccountName(), accountResponse.getAccount().getAccountName());
        Assertions.assertEquals(mockAccount.getAccountBalance(), accountResponse.getAccount().getAccountBalance());
    }

    @Test
    public void testBuildSuccessAccountResponse() {}
}
