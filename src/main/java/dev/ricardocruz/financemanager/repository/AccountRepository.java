package dev.ricardocruz.financemanager.repository;

import dev.ricardocruz.financemanager.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
