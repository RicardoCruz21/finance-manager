package dev.ricardocruz.financemanager.service;

import dev.ricardocruz.financemanager.constants.AccountConstants;
import dev.ricardocruz.financemanager.dto.AccountDto;
import dev.ricardocruz.financemanager.entity.Account;
import dev.ricardocruz.financemanager.exception.AccountServiceException;
import dev.ricardocruz.financemanager.mapper.AccountMapper;
import dev.ricardocruz.financemanager.model.AccountResponse;
import dev.ricardocruz.financemanager.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountResponse createAccount(AccountDto accountDto) {
        Account newAccount;
        try {
            newAccount = accountRepository.save(AccountMapper.mapToEntity(accountDto));
            return buildSuccessResponse(newAccount, AccountConstants.SUCCESS_ACCOUNT_CREATED);
        } catch (Exception ex) {
            LOGGER.error("AccountServiceImpl:createAccount Issue in saving account to repository " + ex.getMessage(), ex);
            throw new AccountServiceException(AccountConstants.ERROR_ACCOUNT_CREATED, ex);
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
