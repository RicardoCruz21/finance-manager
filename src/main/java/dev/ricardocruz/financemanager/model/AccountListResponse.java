package dev.ricardocruz.financemanager.model;

import dev.ricardocruz.financemanager.dto.AccountDto;

import java.util.List;

public class AccountListResponse {
    private boolean success;
    private String message;
    private List<AccountDto> accounts;

    public AccountListResponse() {
    }

    public AccountListResponse(boolean success, String message, List<AccountDto> accounts) {
        this.success = success;
        this.message = message;
        this.accounts = accounts;
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

    public List<AccountDto> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountDto> accounts) {
        this.accounts = accounts;
    }
}
