package dev.ricardocruz.financemanager.mapper;

import dev.ricardocruz.financemanager.dto.AccountDto;
import dev.ricardocruz.financemanager.entity.Account;

public class AccountMapper {

    public static AccountDto mapToDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setAccountName(account.getAccountName());
        accountDto.setAccountBalance(account.getAccountBalance());
        return accountDto;
    }

    public static Account mapToEntity(AccountDto accountDto) {
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setAccountName(accountDto.getAccountName());
        account.setAccountBalance(accountDto.getAccountBalance());
        return account;
    }
}
