package dev.ricardocruz.financemanager.service;

import dev.ricardocruz.financemanager.dto.AccountDto;
import dev.ricardocruz.financemanager.entity.Account;
import dev.ricardocruz.financemanager.exception.AccountServiceException;
import dev.ricardocruz.financemanager.mapper.AccountMapper;
import dev.ricardocruz.financemanager.model.AccountResponse;
import dev.ricardocruz.financemanager.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final String SUCCESS_ACCOUNT_CREATED = "Success: Account created successfully!";
    private final String ERROR_ACCOUNT_CREATED = "Error: Something went wrong when creating the account.";

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountResponse createAccount(AccountDto accountDto) {
        Account newAccount;
        try {
            newAccount = accountRepository.save(AccountMapper.mapToEntity(accountDto));
            return buildSuccessResponse(newAccount, SUCCESS_ACCOUNT_CREATED);
        } catch (Exception ex) {
            throw new AccountServiceException(ERROR_ACCOUNT_CREATED, ex);
        }
    }

    private AccountResponse buildSuccessResponse(Account account, String message) {
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setSuccess(true);
        accountResponse.setMessage(message);
        accountResponse.setAccount(AccountMapper.mapToDto(account));
        return accountResponse;
    }
}
