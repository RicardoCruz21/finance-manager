package dev.ricardocruz.financemanager.service;

import dev.ricardocruz.financemanager.constants.AccountConstants;
import dev.ricardocruz.financemanager.dto.AccountDto;
import dev.ricardocruz.financemanager.entity.Account;
import dev.ricardocruz.financemanager.exception.AccountServiceException;
import dev.ricardocruz.financemanager.mapper.AccountMapper;
import dev.ricardocruz.financemanager.model.AccountListResponse;
import dev.ricardocruz.financemanager.model.AccountResponse;
import dev.ricardocruz.financemanager.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountListResponse getAllAccounts() {
        List<Account> accounts;
        try {
            accounts = accountRepository.findAll();
            return buildSuccessAccountListResponse(accounts);
        } catch (Exception ex) {
            LOGGER.error("AccountServiceImpl:getAllAccounts Error while retrieving accounts from repository " + ex.getMessage(), ex);
            throw new AccountServiceException(AccountConstants.ERROR_ACCOUNTS_RETRIEVED, ex);
        }
    }

    @Override
    public AccountResponse getAccountById(Long id) {
        return null;
    }

    @Override
    public AccountResponse createAccount(AccountDto accountDto) {
        Account newAccount;
        try {
            newAccount = accountRepository.save(AccountMapper.mapToEntity(accountDto));
            return buildSuccessAccountResponse(newAccount, AccountConstants.SUCCESS_ACCOUNT_CREATED);
        } catch (Exception ex) {
            LOGGER.error("AccountServiceImpl:createAccount Error while saving account to repository " + ex.getMessage(), ex);
            throw new AccountServiceException(AccountConstants.ERROR_ACCOUNT_CREATED, ex);
        }
    }

    @Override
    public AccountResponse updateAccount(Long id, AccountDto accountDto) {
        return null;
    }

    @Override
    public AccountResponse deleteAccount(Long id) {
        return null;
    }

    private AccountResponse buildSuccessAccountResponse(Account account, String message) {
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setSuccess(true);
        accountResponse.setMessage(message);
        accountResponse.setAccount(AccountMapper.mapToDto(account));
        return accountResponse;
    }

    private AccountListResponse buildSuccessAccountListResponse(List<Account> accounts) {
        AccountListResponse accountListResponse = new AccountListResponse();
        accountListResponse.setSuccess(true);
        accountListResponse.setMessage(AccountConstants.SUCCESS_ACCOUNTS_RETRIEVED);
        accountListResponse.setAccounts(AccountMapper.mapToDtoList(accounts));
        return accountListResponse;
    }
}
