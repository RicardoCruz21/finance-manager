package dev.ricardocruz.financemanager.dto;

import java.math.BigDecimal;

public class AccountCreationRequest {
    public String accountName;
    public BigDecimal accountBalance;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }
}
