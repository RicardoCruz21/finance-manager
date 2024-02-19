package dev.ricardocruz.financemanager.model;

import dev.ricardocruz.financemanager.dto.AccountDto;

public class AccountResponse {
    private boolean success;
    private String message;
    private AccountDto account;

    public AccountResponse() {
    }

    public AccountResponse(boolean success, String message, AccountDto account) {
        this.success = success;
        this.message = message;
        this.account = account;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AccountDto getAccount() {
        return account;
    }

    public void setAccount(AccountDto account) {
        this.account = account;
    }
}
