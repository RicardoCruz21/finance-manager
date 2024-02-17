package dev.ricardocruz.financemanager.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Table(name = "accounts")
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_name", nullable = false)
    private String accountName;
    @Column(name = "account_balance", precision = 11, scale = 2)
    private BigDecimal accountBalance;

    public Account(Long id, String accountName, BigDecimal accountBalance) {
        this.id = id;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
