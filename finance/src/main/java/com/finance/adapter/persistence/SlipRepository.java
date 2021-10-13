package com.finance.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlipRepository extends JpaRepository<Slip, String> {
    List<Slip> findByTransactions(Transactions transactions);
}
